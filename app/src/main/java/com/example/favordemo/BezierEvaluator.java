package com.example.favordemo;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

//估值器
public class BezierEvaluator implements TypeEvaluator<PointF> {

    private PointF pointF1;
    private PointF pointF2;

    @Override
    //public PointF evaluate(float fraction, PointF startValue, PointF endValue)
    public PointF evaluate(float t, PointF pointF0, PointF pointF3) {
        //t百分比：0~1
        // b(t)=p0*(1-t)*(1-t)*(1-t)+3*p1*t*(1-t)*(1-t)+3*p2*t*t*(1-t)+p3*t*t*t
        PointF pointF = new PointF();
        pointF.x = pointF0.x * (1 - t) * (1 - t) * (1 - t) + 3 * pointF1.x * t * (1 - t) * (1 - t) +
                3 * pointF2.x * t * t * (1 - t)
                + pointF3.x * t * t * t;
        pointF.y = pointF0.y  * (1 - t) * (1 - t) * (1 - t) + 3 * pointF1.y  * t * (1 - t) * (1 - t) +
                3 * pointF2.y  * t * t * (1 - t)
                + pointF3.y  * t * t * t;
        return pointF;
    }

    public BezierEvaluator(PointF pointF1, PointF pointF2){
        this.pointF1 = pointF1;
        this.pointF2 = pointF2;

    }
}
