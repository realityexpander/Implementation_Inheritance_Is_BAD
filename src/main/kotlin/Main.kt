// Demonstration program to illustrate the problems with implementation inheritance.

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

open class Dog {
	fun bark() {
		println("Woof!")
	}

	open fun barkMany(times: Int) {
		for (i in 1..times) {
			bark()
		}
	}
}

/*
// ...there's trouble in paradise...

// ⬇︎⚠️ NEW AND IMPROVED DOG (but completely unaware how someone else is using the old implementation)
open class Dog {
	fun bark() {
		barkMany(1)
	}

	open fun barkMany(times: Int) {
		for (i in 1..times) {
			print("Woof!")
		}
	}
}
*/

class VerboseDog: Dog() {
	override fun barkMany(times: Int) {
		for (i in 1..times) {
			super.bark()
		}
	}
}


fun main() {
   val dog = VerboseDog()

	dog.barkMany(3)
}