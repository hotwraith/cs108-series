package serie5;

import static java.lang.Math.sqrt;

public record Complex(double real, double imagine) {

    public Complex add(Complex toAdd) {
        return new Complex(real + toAdd.real, imagine + toAdd.imagine);
    }

    public double module() {
        return sqrt(this.real * this.real + this.imagine * this.imagine);
    }

    public double moduleSquared() {
        return this.real * this.real + this.imagine * this.imagine;
    }

    public Complex square() {
        return new Complex(
                this.real*this.real - this.imagine*this.imagine,
                this.real*this.imagine*2
        );
    }

}
