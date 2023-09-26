package main

import (
	queueTAD "estrutura-de-dados/queue/queue"
	stackTAD "estrutura-de-dados/queue/stack"
	"fmt"
)

func main() {
	queueList_test()
}

func queueArray_test() {
	queue := queueTAD.NewQueueArray(5)
	queue.EnQueue(1)
	queue.EnQueue(2)
	queue.EnQueue(3)

	i, err := queue.DeQueue()
	if err == nil {
		fmt.Printf("%d\n", i)
	} else {
		fmt.Printf("err: %v\n", err)
	}
}

func queueList_test(){
	queue := queueTAD.NewQueueList()
	queue.EnQueue(1)
	queue.EnQueue(2)
	queue.EnQueue(3)

	i, err := queue.DeQueue()
	if err == nil {
		fmt.Printf("%d\n", i)
	} else {
		fmt.Printf("err: %v\n", err)
	}
}

func stack_test() {
	stack := stackTAD.Stack{}
	stack.Push("3")
	stack.Push("2")
	stack.Push("1")
	fmt.Println(stack.Peek())
	fmt.Println(stack.Pop())
	fmt.Println(stack.Pop())
	fmt.Println(stack.Pop())
	fmt.Println()
	fmt.Println(stackTAD.HtmlIsOk("<html><body><p>Texto</p></body></html>"))
	fmt.Println(stackTAD.HtmlIsOk("<html><body><p>Texto</body></html>"))
}
