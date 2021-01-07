// Create Chitty Chitty Bang Bang
// Extends of Plane, Car and Ship
// Each one do a specific required action like flying, driving or sailing
// Create everithing we need to create the class ChittyChittyBangBang
// that has to be able to do those actions

object Actions extends Enumeration {
    val FLYING, DRIVING, SAILING = Value
}

trait Transformer extends Car with Plane with Ship {
    protected var poweredEngine = false
    protected var action: Actions.Value = Actions.DRIVING // Default action when its engine is turned on
}

trait Car {
    def drive;
}

trait Plane {
    def fly;
}

trait Ship {
    def sail;
}


class ChittyChittyBangBang extends Transformer {
    
    // Only affects in those status that requires the engine has to be turned on
    private def statusOnEngine(act: Actions.Value): Unit = {
        if(poweredEngine == true) {
            action = act
            act match {
                case Actions.DRIVING => println("You are driving!")
                case Actions.FLYING => println("You are flying!")
                case Actions.SAILING => println("You are sailing!")
            }
        } else {
            println("The engine is turned off")
            act match {
                case Actions.DRIVING => println("You cannot drive!")
                case Actions.FLYING => println("You cannot fly!")
                case Actions.SAILING => println("You cannot sail!")
            }
        }
    }

    private def changeStatus(act: Actions.Value): Unit = act match {
        case Actions.DRIVING => statusOnEngine(act)
        case Actions.FLYING => statusOnEngine(act)
        case Actions.SAILING => statusOnEngine(act)
    }

    def stop(): Unit = {
        if (poweredEngine == false) {
            return println("The engine is already off")
        }

        poweredEngine = false
        action = Actions.DRIVING
        println("The engine is turned off!")
    }

    def run(): Unit = {
        if (poweredEngine == true) {
            return println("The engine is already on")
        }

        poweredEngine == true
        println("The engine is turned on!")
    }

    def drive(): Unit = changeStatus(Actions.DRIVING)
    
    def fly(): Unit = changeStatus(Actions.FLYING)
    
    def sail(): Unit = changeStatus(Actions.SAILING)

    
    def status(): Unit = action match {
        case Actions.DRIVING => println("Driving!")
        case Actions.FLYING => println("Flying!")
        case Actions.SAILING => println("Sailing!")
    }

}

object MainObject extends App {
    override def main(args: Array[String]): Unit = {
        val ccbb = new ChittyChittyBangBang()
    }
}