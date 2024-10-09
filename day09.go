//921 - minimum add to make parenthesis valid
//My Go programming approach
func minAddToMakeValid(s string) int {
    close:=0
    open:=0
    for _, char := range s {
        if char == '(' {
            open++
        } else if open > 0 && char == ')' {
            open--
        } else {
            close++
        }
    }
    return open + close
}
