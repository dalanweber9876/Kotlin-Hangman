fun main() {
    var word = "Balloon"

    val letters = mutableListOf<Letter>()
    for (character in word)
    {
        var newLetter = Letter(character)
        letters.add(newLetter)
    }

    var turnCounter = 0
    while(!allVisible(letters) && turnCounter < 6) {
        guess(letters)
        displayWord(letters)
        turnCounter += 1
    }
    println("")
    if (allVisible(letters)){
        println("Great Job!")
    } else {
        println("Haha, Loser")
    }
}

fun guess(letters: List<Letter>) {
    println("Guess a letter")
    var userInput = readLine() ?: " "
    var userInputChar = userInput.get(0)

    for (letter in letters)
    {
        if (userInputChar == letter.letter)
        {
            letter.hidden = false
        }
    }
}

fun displayWord(letters: List<Letter>) {
    for (letter in letters)
    {
        letter.GetRenderedText()
    }
}

fun allVisible(letters: List<Letter>): Boolean {
    for (letter in letters)
    {
        if (letter.hidden != false)
        {
            return false
        }
    }
    return true
}