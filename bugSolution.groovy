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


// Solution 1: Using findIndexOf

def myMethodCorrected1(List<String> list) {
  def index = list.findIndexOf { it == "someValue" }
  if (index != -1) {
    println("Found at index: $index")
    // Do something
  } else {
    println("Completed")
  }
}

myMethodCorrected1(['a', 'b', 'someValue', 'c'])


// Solution 2: Using a flag

def myMethodCorrected2(List<String> list) {
  boolean found = false
  list.eachWithIndex { element, index ->
    if (element == "someValue") {
      found = true
      println("Found at index: $index")
      //Do something
      return //Return correctly exits the loop
    }
  }
  if (!found) {
    println("Completed")
  }
}

myMethodCorrected2(['a', 'b', 'someValue', 'c']) 

//Solution 3: Using iterator

def myMethodCorrected3(List<String> list) {
    def iter = list.iterator()
    while (iter.hasNext()) {
        def item = iter.next()
        if (item == "someValue") {
            println("Found at index: ${list.indexOf(item)}")
            break //break exits the loop
        }
    }
}
myMethodCorrected3(['a', 'b', 'someValue', 'c'])
```