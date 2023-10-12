package androidx.constraintlayout.compose;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.constraintlayout.core.motion.Motion;
import java.util.HashMap;

class MotionRenderDebug {
    private static final int DEBUG_PATH_TICKS_PER_MS = 16;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    static final int MAX_KEY_FRAMES = 50;
    final int DIAMOND_SIZE = 10;
    final int GRAPH_COLOR = -13391360;
    final int KEYFRAME_COLOR = -2067046;
    final int RED_COLOR = -21965;
    final int SHADOW_COLOR = 1996488704;
    Rect mBounds = new Rect();
    DashPathEffect mDashPathEffect;
    Paint mFillPaint;
    int mKeyFrameCount;
    float[] mKeyFramePoints;
    Paint mPaint;
    Paint mPaintGraph;
    Paint mPaintKeyframes;
    Path mPath;
    int[] mPathMode;
    float[] mPoints;
    boolean mPresentationMode = false;
    private float[] mRectangle;
    int mShadowTranslate = 1;
    Paint mTextPaint;

    public MotionRenderDebug(float f) {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-21965);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.mPaintKeyframes = paint2;
        paint2.setAntiAlias(true);
        this.mPaintKeyframes.setColor(-2067046);
        this.mPaintKeyframes.setStrokeWidth(2.0f);
        this.mPaintKeyframes.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.mPaintGraph = paint3;
        paint3.setAntiAlias(true);
        this.mPaintGraph.setColor(-13391360);
        this.mPaintGraph.setStrokeWidth(2.0f);
        this.mPaintGraph.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint();
        this.mTextPaint = paint4;
        paint4.setAntiAlias(true);
        this.mTextPaint.setColor(-13391360);
        this.mTextPaint.setTextSize(f);
        this.mRectangle = new float[8];
        Paint paint5 = new Paint();
        this.mFillPaint = paint5;
        paint5.setAntiAlias(true);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.mDashPathEffect = dashPathEffect;
        this.mPaintGraph.setPathEffect(dashPathEffect);
        this.mKeyFramePoints = new float[100];
        this.mPathMode = new int[50];
        if (this.mPresentationMode) {
            this.mPaint.setStrokeWidth(8.0f);
            this.mFillPaint.setStrokeWidth(8.0f);
            this.mPaintKeyframes.setStrokeWidth(8.0f);
            this.mShadowTranslate = 4;
        }
    }

    public void draw(Canvas canvas, HashMap<String, Motion> hashMap, int i, int i2, int i3, int i4) {
        if (hashMap != null && hashMap.size() != 0) {
            canvas.save();
            for (Motion draw : hashMap.values()) {
                draw(canvas, draw, i, i2, i3, i4);
            }
            canvas.restore();
        }
    }

    public void draw(Canvas canvas, Motion motion, int i, int i2, int i3, int i4) {
        int drawPath = motion.getDrawPath();
        if (i2 > 0 && drawPath == 0) {
            drawPath = 1;
        }
        if (drawPath != 0) {
            this.mKeyFrameCount = motion.buildKeyFrames(this.mKeyFramePoints, this.mPathMode, (int[]) null);
            if (drawPath >= 1) {
                int i5 = i / 16;
                float[] fArr = this.mPoints;
                if (fArr == null || fArr.length != i5 * 2) {
                    this.mPoints = new float[(i5 * 2)];
                    this.mPath = new Path();
                }
                int i6 = this.mShadowTranslate;
                canvas.translate((float) i6, (float) i6);
                this.mPaint.setColor(1996488704);
                this.mFillPaint.setColor(1996488704);
                this.mPaintKeyframes.setColor(1996488704);
                this.mPaintGraph.setColor(1996488704);
                motion.buildPath(this.mPoints, i5);
                Canvas canvas2 = canvas;
                int i7 = drawPath;
                Motion motion2 = motion;
                int i8 = i3;
                int i9 = i4;
                drawAll(canvas2, i7, this.mKeyFrameCount, motion2, i8, i9);
                this.mPaint.setColor(-21965);
                this.mPaintKeyframes.setColor(-2067046);
                this.mFillPaint.setColor(-2067046);
                this.mPaintGraph.setColor(-13391360);
                int i10 = this.mShadowTranslate;
                canvas.translate((float) (-i10), (float) (-i10));
                drawAll(canvas2, i7, this.mKeyFrameCount, motion2, i8, i9);
                if (drawPath == 5) {
                    drawRectangle(canvas, motion);
                }
            }
        }
    }

    public void drawAll(Canvas canvas, int i, int i2, Motion motion, int i3, int i4) {
        if (i == 4) {
            drawPathAsConfigured(canvas);
        }
        if (i == 2) {
            drawPathRelative(canvas);
        }
        if (i == 3) {
            drawPathCartesian(canvas);
        }
        drawBasicPath(canvas);
        drawTicks(canvas, i, i2, motion, i3, i4);
    }

    private void drawBasicPath(Canvas canvas) {
        canvas.drawLines(this.mPoints, this.mPaint);
    }

    private void drawTicks(Canvas canvas, int i, int i2, Motion motion, int i3, int i4) {
        int i5;
        int i6;
        float f;
        float f2;
        int i7;
        Canvas canvas2 = canvas;
        int i8 = i;
        if (motion.getView() != null) {
            i6 = motion.getView().getWidth();
            i5 = motion.getView().getHeight();
        } else {
            i6 = 0;
            i5 = 0;
        }
        for (int i9 = 1; i9 < i2 - 1; i9++) {
            if (i8 != 4 || this.mPathMode[i9 - 1] != 0) {
                float[] fArr = this.mKeyFramePoints;
                int i10 = i9 * 2;
                float f3 = fArr[i10];
                float f4 = fArr[i10 + 1];
                this.mPath.reset();
                this.mPath.moveTo(f3, f4 + 10.0f);
                this.mPath.lineTo(f3 + 10.0f, f4);
                this.mPath.lineTo(f3, f4 - 10.0f);
                this.mPath.lineTo(f3 - 10.0f, f4);
                this.mPath.close();
                int i11 = i9 - 1;
                motion.getKeyFrame(i11);
                if (i8 == 4) {
                    int[] iArr = this.mPathMode;
                    if (iArr[i11] == 1) {
                        drawPathRelativeTicks(canvas2, f3 - 0.0f, f4 - 0.0f);
                    } else if (iArr[i11] == 0) {
                        drawPathCartesianTicks(canvas2, f3 - 0.0f, f4 - 0.0f);
                    } else if (iArr[i11] == 2) {
                        f2 = f4;
                        f = f3;
                        i7 = 2;
                        drawPathScreenTicks(canvas, f3 - 0.0f, f4 - 0.0f, i6, i5, i3, i4);
                        canvas2.drawPath(this.mPath, this.mFillPaint);
                    }
                    f2 = f4;
                    f = f3;
                    i7 = 2;
                    canvas2.drawPath(this.mPath, this.mFillPaint);
                } else {
                    f2 = f4;
                    f = f3;
                    i7 = 2;
                }
                if (i8 == i7) {
                    drawPathRelativeTicks(canvas2, f - 0.0f, f2 - 0.0f);
                }
                if (i8 == 3) {
                    drawPathCartesianTicks(canvas2, f - 0.0f, f2 - 0.0f);
                }
                if (i8 == 6) {
                    drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, i6, i5, i3, i4);
                }
                canvas2.drawPath(this.mPath, this.mFillPaint);
            }
        }
        float[] fArr2 = this.mPoints;
        if (fArr2.length > 1) {
            canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.mPaintKeyframes);
            float[] fArr3 = this.mPoints;
            canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.mPaintKeyframes);
        }
    }

    private void drawTranslation(Canvas canvas, float f, float f2, float f3, float f4) {
        canvas.drawRect(f, f2, f3, f4, this.mPaintGraph);
        canvas.drawLine(f, f2, f3, f4, this.mPaintGraph);
    }

    private void drawPathRelative(Canvas canvas) {
        float[] fArr = this.mPoints;
        canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.mPaintGraph);
    }

    private void drawPathAsConfigured(Canvas canvas) {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.mKeyFrameCount; i++) {
            int[] iArr = this.mPathMode;
            if (iArr[i] == 1) {
                z = true;
            }
            if (iArr[i] == 0) {
                z2 = true;
            }
        }
        if (z) {
            drawPathRelative(canvas);
        }
        if (z2) {
            drawPathCartesian(canvas);
        }
    }

    private void drawPathRelativeTicks(Canvas canvas, float f, float f2) {
        float[] fArr = this.mPoints;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[fArr.length - 2];
        float f6 = fArr[fArr.length - 1];
        float hypot = (float) Math.hypot((double) (f3 - f5), (double) (f4 - f6));
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        float f9 = (((f - f3) * f7) + ((f2 - f4) * f8)) / (hypot * hypot);
        float f10 = f3 + (f7 * f9);
        float f11 = f4 + (f9 * f8);
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f10, f11);
        float hypot2 = (float) Math.hypot((double) (f10 - f), (double) (f11 - f2));
        String str = "" + (((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
        getTextBounds(str, this.mTextPaint);
        canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - ((float) (this.mBounds.width() / 2)), -20.0f, this.mTextPaint);
        canvas.drawLine(f, f2, f10, f11, this.mPaintGraph);
    }

    /* access modifiers changed from: package-private */
    public void getTextBounds(String str, Paint paint) {
        paint.getTextBounds(str, 0, str.length(), this.mBounds);
    }

    private void drawPathCartesian(Canvas canvas) {
        float[] fArr = this.mPoints;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[fArr.length - 2];
        float f4 = fArr[fArr.length - 1];
        canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.mPaintGraph);
        canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.mPaintGraph);
    }

    private void drawPathCartesianTicks(Canvas canvas, float f, float f2) {
        Canvas canvas2 = canvas;
        float[] fArr = this.mPoints;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[fArr.length - 2];
        float f6 = fArr[fArr.length - 1];
        float min = Math.min(f3, f5);
        float max = Math.max(f4, f6);
        float min2 = f - Math.min(f3, f5);
        float max2 = Math.max(f4, f6) - f2;
        String str = "" + (((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f5 - f3))) + 0.5d))) / 100.0f);
        getTextBounds(str, this.mTextPaint);
        canvas2.drawText(str, ((min2 / 2.0f) - ((float) (this.mBounds.width() / 2))) + min, f2 - 20.0f, this.mTextPaint);
        canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.mPaintGraph);
        String str2 = "" + (((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f6 - f4))) + 0.5d))) / 100.0f);
        getTextBounds(str2, this.mTextPaint);
        canvas2.drawText(str2, f + 5.0f, max - ((max2 / 2.0f) - ((float) (this.mBounds.height() / 2))), this.mTextPaint);
        canvas.drawLine(f, f2, f, Math.max(f4, f6), this.mPaintGraph);
    }

    private void drawPathScreenTicks(Canvas canvas, float f, float f2, int i, int i2, int i3, int i4) {
        Canvas canvas2 = canvas;
        String str = "" + (((float) ((int) (((double) (((f - ((float) (i / 2))) * 100.0f) / ((float) (i3 - i)))) + 0.5d))) / 100.0f);
        getTextBounds(str, this.mTextPaint);
        canvas2.drawText(str, ((f / 2.0f) - ((float) (this.mBounds.width() / 2))) + 0.0f, f2 - 20.0f, this.mTextPaint);
        canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.mPaintGraph);
        String str2 = "" + (((float) ((int) (((double) (((f2 - ((float) (i2 / 2))) * 100.0f) / ((float) (i4 - i2)))) + 0.5d))) / 100.0f);
        getTextBounds(str2, this.mTextPaint);
        canvas2.drawText(str2, f + 5.0f, 0.0f - ((f2 / 2.0f) - ((float) (this.mBounds.height() / 2))), this.mTextPaint);
        canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.mPaintGraph);
    }

    private void drawRectangle(Canvas canvas, Motion motion) {
        this.mPath.reset();
        for (int i = 0; i <= 50; i++) {
            motion.buildRect(((float) i) / ((float) 50), this.mRectangle, 0);
            Path path = this.mPath;
            float[] fArr = this.mRectangle;
            path.moveTo(fArr[0], fArr[1]);
            Path path2 = this.mPath;
            float[] fArr2 = this.mRectangle;
            path2.lineTo(fArr2[2], fArr2[3]);
            Path path3 = this.mPath;
            float[] fArr3 = this.mRectangle;
            path3.lineTo(fArr3[4], fArr3[5]);
            Path path4 = this.mPath;
            float[] fArr4 = this.mRectangle;
            path4.lineTo(fArr4[6], fArr4[7]);
            this.mPath.close();
        }
        this.mPaint.setColor(1140850688);
        canvas.translate(2.0f, 2.0f);
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.translate(-2.0f, -2.0f);
        this.mPaint.setColor(-65536);
        canvas.drawPath(this.mPath, this.mPaint);
    }
}
