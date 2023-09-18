package main

import (
	"fmt"
	"strings"
)

type Node struct {
	Data string
	Next *Node
}

type Stack struct {
	Head *Node
}

func (s *Stack) push(data string) {
	temp := Node{Data: data, Next: s.Head}
	s.Head = &temp
}

func (s *Stack) pop() (string, error) {
	if s.Head == nil {
		return "0", fmt.Errorf("Pilha vazia")
	}
	data := s.Head.Data
	s.Head = s.Head.Next
	return data, nil
}

func (s *Stack) peek() (string, error) {
	if s.Head == nil {
		return "0", fmt.Errorf("Pilha vazia")
	}
	return s.Head.Data, nil
}

func (s *Stack) is_empty() bool {
	return s.Head == nil
}

func delimiterIsOk(expression string) bool {
	stack := Stack{}
	for _, char := range expression {
		if strings.Contains("({[", string(char)) {
			stack.push(string(char))
		}
		if strings.Contains(")}]", string(char)) {
			data, err := stack.pop()
			if err != nil {
				return false
			}
			if data == "(" && string(char) != ")" {
				return false
			}
			if data == "[" && string(char) != "]" {
				return false
			}
			if data == "{" && string(char) != "}" {
				return false
			}
		}
	}
	return true
}

func htmlIsOk(html string) bool {
	stack := Stack{}
	var count int
	for count <= len(html) {
		start := findInText(html, "<", count)
		end := findInText(html, ">", start+1)

		if start < 0 || end < 0 {
			break
		}

		tag := html[start+1 : end]

		if !strings.HasPrefix(tag, "/") {
			stack.push(tag)
		} else {
			top, err := stack.pop()

			if err != nil {
				return false
			}
			if top != tag[1:] {
				return false
			}
		}
		count = end + 1
	}
	return stack.is_empty()
}
func findInText(text string, target string, start int) int {
	for i := start; i < len(text); i++ {
		if target == string(text[i]) {
			return i
		}
	}
	return -1
}

func main() {
	stack := Stack{}
	stack.push("3")
	stack.push("2")
	stack.push("1")
	fmt.Println(stack.peek())
	fmt.Println(stack.pop())
	fmt.Println(stack.pop())
	fmt.Println(stack.pop())

	fmt.Println()
	fmt.Println(htmlIsOk("<html><body><p>Texto</p></body></html>"))
	fmt.Println(htmlIsOk("<html><body><p>Texto</body></html>"))
}
