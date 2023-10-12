package androidx.savedstate;

import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;

public final class SavedStateRegistry {
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    boolean mAllowingSavingState = true;
    private boolean mAttached;
    private final SafeIterableMap<String, SavedStateProvider> mComponents = new SafeIterableMap<>();
    private Recreator.SavedStateProvider mRecreatorProvider;
    private boolean mRestored;
    private Bundle mRestoredState;

    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    public interface SavedStateProvider {
        Bundle saveState();
    }

    SavedStateRegistry() {
    }

    public Bundle consumeRestoredStateForKey(String str) {
        if (this.mRestored) {
            Bundle bundle = this.mRestoredState;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.mRestoredState.remove(str);
            if (this.mRestoredState.isEmpty()) {
                this.mRestoredState = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public void registerSavedStateProvider(String str, SavedStateProvider savedStateProvider) {
        if (this.mComponents.putIfAbsent(str, savedStateProvider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public SavedStateProvider getSavedStateProvider(String str) {
        Iterator<Map.Entry<String, SavedStateProvider>> it = this.mComponents.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (((String) next.getKey()).equals(str)) {
                return (SavedStateProvider) next.getValue();
            }
        }
        return null;
    }

    public void unregisterSavedStateProvider(String str) {
        this.mComponents.remove(str);
    }

    public boolean isRestored() {
        return this.mRestored;
    }

    public void runOnNextRecreation(Class<? extends AutoRecreated> cls) {
        if (this.mAllowingSavingState) {
            if (this.mRecreatorProvider == null) {
                this.mRecreatorProvider = new Recreator.SavedStateProvider(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                this.mRecreatorProvider.add(cls.getName());
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* access modifiers changed from: package-private */
    public void performAttach(Lifecycle lifecycle) {
        if (!this.mAttached) {
            lifecycle.addObserver(new LifecycleEventObserver() {
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    SavedStateRegistry.this.lambda$performAttach$0$SavedStateRegistry(lifecycleOwner, event);
                }
            });
            this.mAttached = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.");
    }

    public /* synthetic */ void lambda$performAttach$0$SavedStateRegistry(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_START) {
            this.mAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this.mAllowingSavingState = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void performRestore(Bundle bundle) {
        if (!this.mAttached) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        } else if (!this.mRestored) {
            if (bundle != null) {
                this.mRestoredState = bundle.getBundle(SAVED_COMPONENTS_KEY);
            }
            this.mRestored = true;
        } else {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
    }

    /* access modifiers changed from: package-private */
    public void performSave(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.mRestoredState;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = this.mComponents.iteratorWithAdditions();
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
            bundle2.putBundle((String) entry.getKey(), ((SavedStateProvider) entry.getValue()).saveState());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle(SAVED_COMPONENTS_KEY, bundle2);
        }
    }
}
