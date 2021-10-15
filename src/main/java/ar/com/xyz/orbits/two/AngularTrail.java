package ar.com.xyz.orbits.two;

public class AngularTrail {
/*
    constructor() {
        this.points = [];
        this.angles = [];
        this.color = 'white';
        this.threshold = Math.PI/180;
    }
    calcNewestAngle(px, py)
    {
        let len = this.points.length;
        let p0 = this.points[len-2];
        let p1 = this.points[len-1];
        let v1x = p1[0] - p0[0];
        let v1y = p1[1] - p0[1];
        let v2x = px - p1[0];
        let v2y = py - p1[1];
        let lv1 = Math.sqrt(v1x*v1x + v1y*v1y);
        let lv2 = Math.sqrt(v2x*v2x + v2y*v2y);
        let dot = v1x*v2x + v1y*v2y;
        let cosa = dot / (lv1 * lv2);
        return Math.acos(cosa);
    }
    update(px, py) {
        let len = this.points.length;
        if (len <= 3) {
            this.points.push([px, py])
            this.angles.push(0);
        }
        else {
            let a = this.calcNewestAngle(px, py);
            if (a < this.threshold) {
                this.points.pop();
                this.angles.pop();
                a = this.calcNewestAngle(px, py);
            }
            this.angles.push(this.angles[this.angles.length-1] + a);
            this.points.push([px, py])
        }
        while (Math.abs(this.angles[this.angles.length-1] - this.angles[0]) > 2 * Math.PI) {
            this.points.shift();
            this.angles.shift();
        }
    }
    draw(ez) {
        linecolor(this.color)
        for (let i = 1; i < this.points.length; i++) {
            let p0 = this.points[i-1];
            let p1 = this.points[i];
            let x0 = p0[0], y0 = p0[1];
            let x1 = p1[0], y1 = p1[1];
            let a = (i / this.points.length);
            ctx().globalAlpha = a;
            line(x0, y0, x1, y1);
        }
        ctx().globalAlpha = 1;
    }
*/
}
