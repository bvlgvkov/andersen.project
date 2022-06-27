package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SquareTriangle {
    public final int a;
    public final int b;
    public final int c;

    public double perimeter() {
        return (double)(this.a + this.b + this.c) / 2.0;
    }

    public double square() {
        return Math.sqrt(this.perimeter() * (this.perimeter() -
                (double)this.a) * (this.perimeter() - (double)this.b) * (this.perimeter() - (double)this.c));
    }

}
