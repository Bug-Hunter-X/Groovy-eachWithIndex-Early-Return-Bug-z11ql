```groovy
def myMethod(List<String> list) {
  list.eachWithIndex { element, index ->
    if (element == "someValue") {
      // Do something
      return //Incorrect early return, only exits the eachWithIndex closure
    }
  }
  println("Completed")
}

myMethod(['a', 'b', 'someValue', 'c']) //Prints Completed
```