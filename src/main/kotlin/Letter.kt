class Letter (
    var letter : Char,
    var hidden : Boolean = true
){
    fun Hide() {
        hidden = true
    }

    fun Show () {
        hidden = false
    }

    fun IsHidden(): Boolean {
        return hidden
    }

    fun GetRenderedText() {
        if (hidden) {
            print("_ ")
        } else (
            print("$letter ")
        )
    }
}