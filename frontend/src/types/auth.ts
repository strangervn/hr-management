export interface User {
  id: number;
  username: string;
  email: string;
  role: string | string[];
}

export interface AuthResponse {
  token: string;
  type: string;
  id: number;
  username: string;
  email: string;
  roles: string;
}

export interface LoginCredentials {
  username?: string;
  password?: string;
}

export interface RegisterData {
  username?: string;
  email?: string;
  password?: string;
  role?: string;
}
