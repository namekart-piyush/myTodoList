import { Todo } from "../types/todo";

const API_URL = 'http://localhost:8080/api';

export const todoService = {
  async getAllTodos(): Promise<Todo[]> {
    const response = await fetch(`${API_URL}/todos`);
    return response.json();
  },

  async createTodo(title: string): Promise<Todo> {
    const response = await fetch(`${API_URL}/todos`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ title, completed: false }),
    });
    return response.json();
  },

  async updateTodo(todo: Todo): Promise<Todo> {
    const response = await fetch(`${API_URL}/todos/${todo.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(todo),
    });
    return response.json();
  },

  async deleteTodo(id: number): Promise<void> {
    await fetch(`${API_URL}/todos/${id}`, {
      method: 'DELETE',
    });
  },
};