package connect_4

class ConnectFour {
    val board: Array<Array<String>> = Array(6) { Array(7) { " " } }
    fun checkWin(): Boolean {
        for (row in 0..3) {
            for (col in 0..2) {
                if (board[row][col] != " " &&
                    board[row][col] == board[row + 1][col + 1] &&
                    board[row][col] == board[row + 2][col + 2] &&
                    board[row][col] == board[row + 3][col + 3]
                ) {
                    return true
                }
            }
        }
        for (row in 0..3) {
            for (col in 6 downTo 3) {
                if (board[row][col] != " " &&
                    board[row][col] == board[row + 1][col - 1] &&
                    board[row][col] == board[row + 2][col - 2] &&
                    board[row][col] == board[row + 3][col - 3]
                ) {
                    return true
                }

            }
        }
        //check winner ' horizontal line '
        for (row in 0 until 6){
                   for (col in 0 until 3){
                       if (board[row][col] != " " &&
                           board[row][col] == board[row][col + 1] &&
                           board[row][col] == board[row][col + 2] &&
                           board[row][col] == board[row][col + 3])
                       {
                           return true
                       }
                   }
               }
         //check winner ' vertical line '
         for (col in 0 until 7){
                    for (row in 0 until 3){
                        if (board[row][col] != " " &&
                            board[row][col] == board[row + 1][col] &&
                            board[row][col] == board[row + 2][col] &&
                            board[row][col] == board[row + 3][col])
                        {
                            return true
                        }
                    }
         }
        return false
    }

    fun checkDraw() : Boolean
    {
        // write the code of check draw function here
        // the true return value is to avoid the error only you can delete it
        return true
    }

    fun printBoard() {
        val numRows = board.size
        val numCols = board[0].size

        // Print column numbers
        for (col in 1..numCols) {
            print("   $col  ")
        }
        println()

        // Print board with boundaries
        for (row in 0 until numRows) {
            // Print top boundary for each row
            for (col in 0 until numCols) {
                print("______")
            }
            println()

            // Print cell values and number
            for (col in 0 until numCols) {
                print("|  ${board[row][col]}  ")
            }
            println("|")
        }

        // Print bottom boundary for the last row
        for (col in 0 until numCols) {
            print("______")
        }
        println()
        println()
    }

    fun gamePlay() {
        val rows = 6
        val cols = 7
        var currentPlayer = "X"

        while (true) {

            // Print board
            printBoard()

            // Get column choice from the current player
            println("Player $currentPlayer's turn.")
            print("Enter column (1-$cols): ")
            val column = readlnOrNull()?.toIntOrNull()

            if (column != null && column in 1..cols) {
                // Place the current player's piece in the chosen column
                for (row in rows - 1 downTo 0) {
                    if (board[row][column - 1] == " ") {
                        board[row][column - 1] = currentPlayer
                        break
                    }
                }

                // Check if the current player wins
                if (checkWin()) {
                    // Print final board
                    printBoard()
                    println("Player $currentPlayer wins!")
                    break
                }

                // Check if it's a draw
                if (checkDraw()) {
                    // Print final board
                    printBoard()
                    println("It's a draw!")
                    break
                }

                // Switch to the other player
                currentPlayer = if (currentPlayer == "X") "O" else "X"
            } else {
                println("Invalid column choice. Please try again.")
            }
        }
    }
}
