package com.reactnativepagerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.reactnativepagerview.event.PageSelectedEvent;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0016\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014H\u0016J \u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00140\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\"\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0019\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\fH\u0002J \u0010)\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u001dH\u0002J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\fH\u0007J\u0018\u0010-\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0015H\u0007J\u0018\u0010.\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0015H\u0007J\u0018\u0010/\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0015H\u0007J\u0018\u00100\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u00101\u001a\u000202H\u0007J\u0018\u00103\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u001dH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/reactnativepagerview/PagerViewViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/reactnativepagerview/NestedScrollableHost;", "()V", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "addView", "", "host", "child", "Landroid/view/View;", "index", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getChildAt", "parent", "getChildCount", "getCommandsMap", "", "", "getExportedCustomDirectEventTypeConstants", "", "getName", "getViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "view", "needsCustomLayoutForChildren", "", "receiveCommand", "root", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "refreshViewChildrenLayout", "removeAllViews", "removeView", "removeViewAt", "set", "value", "setCurrentItem", "selectedTab", "scrollSmooth", "setInitialPage", "setLayoutDirection", "setOrientation", "setOverScrollMode", "setPageMargin", "margin", "", "setScrollEnabled", "Companion", "react-native-pager-view_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PagerViewViewManager.kt */
public final class PagerViewViewManager extends ViewGroupManager<NestedScrollableHost> {
    private static final int COMMAND_SET_PAGE = 1;
    private static final int COMMAND_SET_PAGE_WITHOUT_ANIMATION = 2;
    private static final int COMMAND_SET_SCROLL_ENABLED = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String REACT_CLASS = "RNCViewPager";
    /* access modifiers changed from: private */
    public EventDispatcher eventDispatcher;

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public NestedScrollableHost createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        Context context = themedReactContext;
        NestedScrollableHost nestedScrollableHost = new NestedScrollableHost(context);
        nestedScrollableHost.setId(View.generateViewId());
        nestedScrollableHost.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        nestedScrollableHost.setSaveEnabled(false);
        ViewPager2 viewPager2 = new ViewPager2(context);
        viewPager2.setAdapter(new ViewPagerAdapter());
        viewPager2.setSaveEnabled(false);
        NativeModule nativeModule = themedReactContext.getNativeModule(UIManagerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        EventDispatcher eventDispatcher2 = ((UIManagerModule) nativeModule).getEventDispatcher();
        Intrinsics.checkNotNullExpressionValue(eventDispatcher2, "reactContext.getNativeMo…s.java)!!.eventDispatcher");
        this.eventDispatcher = eventDispatcher2;
        viewPager2.post(new Runnable(this, nestedScrollableHost) {
            public final /* synthetic */ PagerViewViewManager f$1;
            public final /* synthetic */ NestedScrollableHost f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                PagerViewViewManager.m4246createViewInstance$lambda0(ViewPager2.this, this.f$1, this.f$2);
            }
        });
        nestedScrollableHost.addView(viewPager2);
        return nestedScrollableHost;
    }

    /* access modifiers changed from: private */
    /* renamed from: createViewInstance$lambda-0  reason: not valid java name */
    public static final void m4246createViewInstance$lambda0(ViewPager2 viewPager2, PagerViewViewManager pagerViewViewManager, NestedScrollableHost nestedScrollableHost) {
        Intrinsics.checkNotNullParameter(viewPager2, "$vp");
        Intrinsics.checkNotNullParameter(pagerViewViewManager, "this$0");
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "$host");
        viewPager2.registerOnPageChangeCallback(new PagerViewViewManager$createViewInstance$1$1(pagerViewViewManager, nestedScrollableHost));
        EventDispatcher eventDispatcher2 = pagerViewViewManager.eventDispatcher;
        if (eventDispatcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
            eventDispatcher2 = null;
        }
        eventDispatcher2.dispatchEvent(new PageSelectedEvent(nestedScrollableHost.getId(), viewPager2.getCurrentItem()));
    }

    private final ViewPager2 getViewPager(NestedScrollableHost nestedScrollableHost) {
        if (nestedScrollableHost.getChildAt(0) instanceof ViewPager2) {
            View childAt = nestedScrollableHost.getChildAt(0);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
            return (ViewPager2) childAt;
        }
        throw new ClassNotFoundException("Could not retrieve ViewPager2 instance");
    }

    private final void setCurrentItem(ViewPager2 viewPager2, int i, boolean z) {
        refreshViewChildrenLayout(viewPager2);
        viewPager2.setCurrentItem(i, z);
    }

    public void addView(NestedScrollableHost nestedScrollableHost, View view, int i) {
        Integer initialIndex;
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        if (view != null) {
            ViewPager2 viewPager = getViewPager(nestedScrollableHost);
            ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
            if (viewPagerAdapter != null) {
                viewPagerAdapter.addChild(view, i);
            }
            if (viewPager.getCurrentItem() == i) {
                refreshViewChildrenLayout(viewPager);
            }
            if (!nestedScrollableHost.getDidSetInitialIndex() && (initialIndex = nestedScrollableHost.getInitialIndex()) != null && initialIndex.intValue() == i) {
                nestedScrollableHost.setDidSetInitialIndex(true);
                setCurrentItem(viewPager, i, false);
            }
        }
    }

    public int getChildCount(NestedScrollableHost nestedScrollableHost) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        RecyclerView.Adapter adapter = getViewPager(nestedScrollableHost).getAdapter();
        if (adapter == null) {
            return 0;
        }
        return adapter.getItemCount();
    }

    public View getChildAt(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) getViewPager(nestedScrollableHost).getAdapter();
        Intrinsics.checkNotNull(viewPagerAdapter);
        return viewPagerAdapter.getChildAt(i);
    }

    public void removeView(NestedScrollableHost nestedScrollableHost, View view) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
        if (viewPagerAdapter != null) {
            viewPagerAdapter.removeChild(view);
        }
        refreshViewChildrenLayout(viewPager);
    }

    public void removeAllViews(NestedScrollableHost nestedScrollableHost) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        viewPager.setUserInputEnabled(false);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
        if (viewPagerAdapter != null) {
            viewPagerAdapter.removeAll();
        }
    }

    public void removeViewAt(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
        if (viewPagerAdapter != null) {
            viewPagerAdapter.removeChildAt(i);
        }
        refreshViewChildrenLayout(viewPager);
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public final void setScrollEnabled(NestedScrollableHost nestedScrollableHost, boolean z) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        getViewPager(nestedScrollableHost).setUserInputEnabled(z);
    }

    @ReactProp(defaultInt = 0, name = "initialPage")
    public final void setInitialPage(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        if (nestedScrollableHost.getInitialIndex() == null) {
            nestedScrollableHost.setInitialIndex(Integer.valueOf(i));
            viewPager.post(new Runnable() {
                public final void run() {
                    PagerViewViewManager.m4251setInitialPage$lambda1(NestedScrollableHost.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setInitialPage$lambda-1  reason: not valid java name */
    public static final void m4251setInitialPage$lambda1(NestedScrollableHost nestedScrollableHost) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "$host");
        nestedScrollableHost.setDidSetInitialIndex(true);
    }

    @ReactProp(name = "orientation")
    public final void setOrientation(NestedScrollableHost nestedScrollableHost, String str) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        Intrinsics.checkNotNullParameter(str, "value");
        getViewPager(nestedScrollableHost).setOrientation(Intrinsics.areEqual((Object) str, (Object) "vertical") ? 1 : 0);
    }

    @ReactProp(defaultInt = -1, name = "offscreenPageLimit")
    public final void set(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        getViewPager(nestedScrollableHost).setOffscreenPageLimit(i);
    }

    @ReactProp(name = "overScrollMode")
    public final void setOverScrollMode(NestedScrollableHost nestedScrollableHost, String str) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        Intrinsics.checkNotNullParameter(str, "value");
        View childAt = getViewPager(nestedScrollableHost).getChildAt(0);
        if (Intrinsics.areEqual((Object) str, (Object) ReactScrollViewHelper.OVER_SCROLL_NEVER)) {
            childAt.setOverScrollMode(2);
        } else if (Intrinsics.areEqual((Object) str, (Object) ReactScrollViewHelper.OVER_SCROLL_ALWAYS)) {
            childAt.setOverScrollMode(0);
        } else {
            childAt.setOverScrollMode(1);
        }
    }

    @ReactProp(name = "layoutDirection")
    public final void setLayoutDirection(NestedScrollableHost nestedScrollableHost, String str) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        Intrinsics.checkNotNullParameter(str, "value");
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        if (Intrinsics.areEqual((Object) str, (Object) "rtl")) {
            viewPager.setLayoutDirection(1);
        } else {
            viewPager.setLayoutDirection(0);
        }
    }

    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        Map<String, Map<String, String>> of = MapBuilder.of("topPageScroll", MapBuilder.of("registrationName", "onPageScroll"), "topPageScrollStateChanged", MapBuilder.of("registrationName", "onPageScrollStateChanged"), "topPageSelected", MapBuilder.of("registrationName", "onPageSelected"));
        Intrinsics.checkNotNullExpressionValue(of, "of(\n      PageScrollEven…Name\", \"onPageSelected\"))");
        return of;
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("setPage", 1, "setPageWithoutAnimation", 2, "setScrollEnabled", 3);
    }

    public void receiveCommand(NestedScrollableHost nestedScrollableHost, int i, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "root");
        super.receiveCommand(nestedScrollableHost, i, readableArray);
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        Assertions.assertNotNull(viewPager);
        Assertions.assertNotNull(readableArray);
        RecyclerView.Adapter adapter = viewPager.getAdapter();
        EventDispatcher eventDispatcher2 = null;
        Integer valueOf = adapter == null ? null : Integer.valueOf(adapter.getItemCount());
        boolean z = false;
        if (i == 1 || i == 2) {
            Intrinsics.checkNotNull(readableArray);
            int i2 = readableArray.getInt(0);
            if (valueOf != null && valueOf.intValue() > 0 && i2 >= 0 && i2 < valueOf.intValue()) {
                if (i == 1) {
                    z = true;
                }
                setCurrentItem(viewPager, i2, z);
                EventDispatcher eventDispatcher3 = this.eventDispatcher;
                if (eventDispatcher3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
                } else {
                    eventDispatcher2 = eventDispatcher3;
                }
                eventDispatcher2.dispatchEvent(new PageSelectedEvent(nestedScrollableHost.getId(), i2));
            }
        } else if (i == 3) {
            Intrinsics.checkNotNull(readableArray);
            viewPager.setUserInputEnabled(readableArray.getBoolean(0));
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("Unsupported command %d received by %s.", Arrays.copyOf(new Object[]{Integer.valueOf(i), getClass().getSimpleName()}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            throw new IllegalArgumentException(format);
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "pageMargin")
    public final void setPageMargin(NestedScrollableHost nestedScrollableHost, float f) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        viewPager.setPageTransformer(new ViewPager2.PageTransformer((int) PixelUtil.toPixelFromDIP(f), viewPager) {
            public final /* synthetic */ int f$0;
            public final /* synthetic */ ViewPager2 f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void transformPage(View view, float f) {
                PagerViewViewManager.m4252setPageMargin$lambda2(this.f$0, this.f$1, view, f);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: setPageMargin$lambda-2  reason: not valid java name */
    public static final void m4252setPageMargin$lambda2(int i, ViewPager2 viewPager2, View view, float f) {
        Intrinsics.checkNotNullParameter(viewPager2, "$pager");
        Intrinsics.checkNotNullParameter(view, "page");
        float f2 = ((float) i) * f;
        if (viewPager2.getOrientation() == 0) {
            boolean z = true;
            if (viewPager2.getLayoutDirection() != 1) {
                z = false;
            }
            if (z) {
                f2 = -f2;
            }
            view.setTranslationX(f2);
            return;
        }
        view.setTranslationY(f2);
    }

    private final void refreshViewChildrenLayout(View view) {
        view.post(new Runnable(view) {
            public final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                PagerViewViewManager.m4250refreshViewChildrenLayout$lambda3(this.f$0);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshViewChildrenLayout$lambda-3  reason: not valid java name */
    public static final void m4250refreshViewChildrenLayout$lambda3(View view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(view.getHeight(), BasicMeasure.EXACTLY));
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reactnativepagerview/PagerViewViewManager$Companion;", "", "()V", "COMMAND_SET_PAGE", "", "COMMAND_SET_PAGE_WITHOUT_ANIMATION", "COMMAND_SET_SCROLL_ENABLED", "REACT_CLASS", "", "react-native-pager-view_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: PagerViewViewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
