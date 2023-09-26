package stack

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

func (s *Stack) Push(data string) {
	temp := Node{Data: data, Next: s.Head}
	s.Head = &temp
}

func (s *Stack) Pop() (string, error) {
	if s.Head == nil {
		return "0", fmt.Errorf("Pilha vazia")
	}
	data := s.Head.Data
	s.Head = s.Head.Next
	return data, nil
}

func (s *Stack) Peek() (string, error) {
	if s.Head == nil {
		return "0", fmt.Errorf("Pilha vazia")
	}
	return s.Head.Data, nil
}

func (s *Stack) Is_empty() bool {
	return s.Head == nil
}

func DelimiterIsOk(expression string) bool {
	stack := Stack{}
	for _, char := range expression {
		if strings.Contains("({[", string(char)) {
			stack.Push(string(char))
		}
		if strings.Contains(")}]", string(char)) {
			data, err := stack.Pop()
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

func HtmlIsOk(html string) bool {
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
			stack.Push(tag)
		} else {
			top, err := stack.Pop()

			if err != nil {
				return false
			}
			if top != tag[1:] {
				return false
			}
		}
		count = end + 1
	}
	return stack.Is_empty()
}
func findInText(text string, target string, start int) int {
	for i := start; i < len(text); i++ {
		if target == string(text[i]) {
			return i
		}
	}
	return -1
}

