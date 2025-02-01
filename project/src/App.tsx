import React, { useState, useEffect } from 'react';
import { PlusCircle } from 'lucide-react';
import { TodoItem } from './components/TodoItem';
import { todoService } from './services/todoService';
import type { Todo } from './types/todo';

function App() {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [newTodo, setNewTodo] = useState('');
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    loadTodos();
  }, []);

  const loadTodos = async () => {
    try {
      const data = await todoService.getAllTodos();
      console.log(data);
      setTodos(data);
    } catch (err) {
      setError('Failed to load todos. Is the backend server running?');
    }
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!newTodo.trim()) return;

    try {
      const todo = await todoService.createTodo(newTodo.trim());
      setTodos([...todos, todo]);
      setNewTodo('');
      setError(null);
    } catch (err) {
      setError('Failed to create todo');
    }
  };

  const handleToggle = async (todo: Todo) => {
    try {
      const updated = await todoService.updateTodo({
        ...todo,
        completed: !todo.completed,
      });
      setTodos(todos.map(t => t.id === todo.id ? updated : t));
      setError(null);
    } catch (err) {
      setError('Failed to update todo');
    }
  };

  const handleDelete = async (id: number) => {
    try {
      await todoService.deleteTodo(id);
      setTodos(todos.filter(t => t.id !== id));
      setError(null);
    } catch (err) {
      setError('Failed to delete todo');
    }
  };

  return (
    <div className="min-h-screen bg-gray-100 py-8">
      <div className="max-w-2xl mx-auto px-4">
        <h1 className="text-3xl font-bold text-gray-800 mb-8">Todo List</h1>
        
        {error && (
          <div className="bg-red-50 text-red-600 p-4 rounded-lg mb-6">
            {error}
          </div>
        )}

        <form onSubmit={handleSubmit} className="mb-8">
          <div className="flex gap-2">
            <input
              type="text"
              value={newTodo}
              onChange={(e) => setNewTodo(e.target.value)}
              placeholder="Add a new todo... Format{task-Deadline}"
              className="flex-1 p-3 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-blue-500"
            />
            <button
              type="submit"
              className="bg-blue-500 text-white px-6 py-3 rounded-lg hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 flex items-center gap-2"
            >
              <PlusCircle className="w-5 h-5" />
              Add
            </button>
          </div>
        </form>

        <div className="space-y-2">
          {todos.map(todo => (
            <TodoItem
              key={todo.id}
              todo={todo}
              onToggle={handleToggle}
              onDelete={handleDelete}
            />
          ))}
        </div>

        {todos.length === 0 && (
          <p className="text-center text-gray-500 mt-8">
            No todos yet. Add one above!
          </p>
        )}
      </div>
    </div>
  );
}

export default App;