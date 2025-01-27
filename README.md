# Groovy eachWithIndex Early Return Bug

This example demonstrates a common pitfall when using `eachWithIndex` in Groovy. An early `return` statement within the closure does *not* exit the `eachWithIndex` method but rather just the closure.  This can lead to unexpected behavior if you intend to stop iteration after a condition is met.

The `bug.groovy` file contains code that incorrectly uses `return` to try to terminate iteration. The `bugSolution.groovy` file provides the correct solution using `eachWithIndex` and alternative methods for handling early termination.
