package week1

object callByType {
	def loop : Boolean = loop  // infinite loop
                                                  //> loop: => Boolean
	
	def callByValueAnd(x: Boolean, y: Boolean) = x && loop
                                                  //> callByValueAnd: (x: Boolean, y: Boolean)Boolean
	def callByNameAnd(x: Boolean, y: => Boolean) = x && loop
                                                  //> callByNameAnd: (x: Boolean, y: => Boolean)Boolean
  callByNameAnd(false, loop)                      //> res0: Boolean = false/
	 // fails
	callByValueAnd(false, loop)
}