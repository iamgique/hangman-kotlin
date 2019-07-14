package iamgique.hangman

fun main(args: Array<String>) {
    println("!!! Welcome to hangman game !!!")
    game(hangmanWords())
}

fun game(words: String) {
    var count = 0
    val char = words.toLowerCase().toCharArray().toHashSet()
    val correct = mutableSetOf<Char>()

    while (char != correct) {
        printFoundChar(words, correct)

        print("\nGuess a word: ")
        val guess = readLine()
        if (guess == null || guess.length != 1) {
            println("Please input or input only one text")
            continue
        }

        if (words.toLowerCase().contains(guess.toLowerCase())) {
            correct.add(guess[0].toLowerCase())
        } else {
            ++count
        }
    }

    println("\nCongratulations you won!!!")
    println("Wrong count: $count")
    printFoundChar(words, correct)
}

fun hangmanWords(): String {
    while (true) {
        print("Please enter the word: ")
        val words = readLine()
        if (words == null || words.isEmpty()) {
            println("Words is empty please try again.")
            continue
        } else {
            return words
        }
    }
}

fun printFoundChar(input: String, correct: Set<Char>) {
    for (char in input.toLowerCase()) {
        if (correct.contains(char)) {
            print(char + " ")
        } else {
            print("_ ")
        }
    }
}