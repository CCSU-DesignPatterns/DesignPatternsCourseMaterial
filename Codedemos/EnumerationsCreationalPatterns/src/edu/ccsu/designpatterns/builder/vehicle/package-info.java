/**
 * This package contains a implementation
 * of the most common type of builder pattern
 * where the builder is used to create a
 * complex composite object using a director.
 * Essentially the builder pattern here is used
 * because the MotorizedVehicle object that is
 * being built has a complex composite construction,
 * meaning it consists of many different parts
 * and it makes sense for the number and types
 * of parts to vary depending on the desired object
 * being constructed.  In this example a director
 * makes sense as there is a lengthy set of steps
 * that are needed to be executed on the builder
 * to construct a full class and from the client
 * perspective it doesn't need to know the details
 * of these just the general versions of the
 * object that it may want ex. motorcycle,
 * 2 door car, 4 door car, 18 wheeler.  Note
 * the resulting objects from this pattern are
 * often then used with a prototype factory
 * pattern to lookup versions of these
 * MotorizedVehicles for later use.
 */
package edu.ccsu.designpatterns.builder.vehicle;