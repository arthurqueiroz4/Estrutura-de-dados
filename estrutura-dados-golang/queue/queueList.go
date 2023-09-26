package queue

type Node struct {
	Data int
	Next *Node
	Prev *Node
}

type QueueList struct {
	Front *Node
	Rear *Node
	Size int
}

func NewQueueList() *QueueList {
	return &QueueList{Size: 0}
}

func (q *QueueList) EnQueue(data int) {
	newNode := &Node{Data: data}
	
	if q.Size == 0 {
		q.Front = newNode
		q.Rear = newNode
		q.Size += 1
		return
	}

	if q.Size == 1 {
		q.Front.Next = newNode
		newNode.Prev = q.Front
		q.Rear = newNode
		q.Size++
		return
	}

	q.Rear.Next = newNode
	newNode.Prev = q.Rear
	q.Rear = newNode
	q.Size++
}

func (q *QueueList) DeQueue() (int, error) {
	if q.Size != 0 {
		data := q.Front.Data
		q.Front = q.Front.Next
		q.Size--
		return data, nil
	}
	return 0, errEmptyQueue
}

func (q *QueueList) Is_empty() bool {
	return q.Size <= 0
}