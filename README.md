descriptive-predicates
======================

A draft implementation for descriptive predicates based on JDK8.

Inspired by [hamcrest](https://github.com/hamcrest/JavaHamcrest).

Descriptive predicates consists of three important aspects;

 - it acts as a <code>Predicate\<T\></code> for a type <code>T</code>,
 - it provides a descriptive message for that predicate, i.e. it has a descriptive <code>toString()</code>, and
 - it acts as a describer for a type <code>T</code>, i.e <code>Function\<T, String\></code>

Descriptive predicates can be used wherever a regular Java 8 <code>Predicate\<T\></code> can
be used, but are particularly useful in some scenarios.

Testing, i.e:

    verifyThat(result, greaterThan(4));
    
Input validation (i.e in production code):

    validate(input, greaterThan(4), otherwiseThrowing(BadRequest.class));
    
Design by contract (i.e assertions in production code):

    require(input, greaterThan(4));
    ...
    ensure(output, greaterThan(5));
    