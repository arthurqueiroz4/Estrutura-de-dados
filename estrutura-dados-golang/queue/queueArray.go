package queue

import (
	"errors"
)

type QueueArray struct {
	Que   []int32
	Limit int32
	Front int32
	Rear  int32
	Size  int32
}

var errEmptyQueue = errors.New("fila vazia")

func NewQueueArray(limit int32) *QueueArray {
	return &QueueArray{make([]int32, limit), limit, 0, 0, 0}
}

func (q *QueueArray) Is_empty() bool {
	return q.Size <= 0
}

func (q *QueueArray) EnQueue(item int32) {
	if q.Size == q.Limit {
		return
	}
	q.Que[q.Rear] = item
	q.Rear = (q.Rear + 1) % q.Limit
	q.Size += 1
}

func (q *QueueArray) DeQueue() (int32, error) {
	if q.Size == 0 {
		return 0, errEmptyQueue
	}
	item := q.Que[q.Front]
	q.Front = (q.Front + 1) % q.Limit
	q.Size -= 1
	return item, nil
}

func (q *QueueArray) QueueRear() (int32, error) {
	if q.Size > 0 {
		return q.Que[q.Rear], nil
	}
	return 0, errEmptyQueue
}

func (q *QueueArray) QueueFront() (int32, error) {
	if q.Size > 0 {
		return q.Que[q.Front], nil
	}
	return 0, errEmptyQueue
}
