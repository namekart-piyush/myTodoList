import React from 'react';
import { Trash2, CheckCircle, Circle } from 'lucide-react';
import type { Todo } from '../types/todo';

interface TodoItemProps {
  todo: Todo;
  onToggle: (todo: Todo) => void;
  onDelete: (id: number) => void;
}

export function TodoItem({ todo, onToggle, onDelete }: TodoItemProps) {
  return (
    <div className="flex items-center justify-between p-4 bg-white rounded-lg shadow-sm mb-2">
      <div className="flex items-center gap-3">
        <button
          onClick={() => onToggle(todo)}
          className="text-gray-500 hover:text-green-500 transition-colors"
        >
          {todo.completed ? (
            <CheckCircle className="w-5 h-5 text-green-500" />
          ) : (
            <Circle className="w-5 h-5" />
          )}
        </button>
        <span className={`${todo.completed ? 'line-through text-gray-400' : 'text-gray-700'}`}>
          {todo.title}
        </span>
      </div>
      <button
        onClick={() => onDelete(todo.id)}
        className="text-gray-400 hover:text-red-500 transition-colors"
      >
        <Trash2 className="w-5 h-5" />
      </button>
    </div>
  );
}