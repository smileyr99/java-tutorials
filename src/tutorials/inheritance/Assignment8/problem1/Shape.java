package tutorials.inheritance.Assignment8.problem1;

// Shape interface

// Design (not implementation) common to both Rectangle
//    and Circle and any other shape-like things is included
//    in the interface Shape.
//    It is much like a class except it only has declarations
//    of its methods, i.e., its design, but not implementation.
//    Some constants are allowed in it, but not fields.
//
// Note that diagonal from Rectangle and circumference
// from Circle are not included because they are specific
// to Rectangle and Circle respectively, but not to Shape
// in general.

// An interface is really a new TYPE that we are defining, much
// like the types that get created when you define classes.
// That is, we can use the interface name, Shape here, as
// the type of some variable later.  This also means that
// if a class 'implements' this interface, the class MUST
// implement ALL the methods that are declared in the interface
// to be able to act as a complete class.  That is, you will
// not be able to create an instance of that class unless the
// class implements ALL of its inherited abstract methods.
// The methods declared in an interface are declared to be abstract.
// These abstract methods become concrete when they are implemented
// in a class that inherits the interface.

public interface Shape {

    public abstract void translate (double dx, double dy);

    public abstract void scale (double factor);

    public abstract Box boundingBox ();

}
