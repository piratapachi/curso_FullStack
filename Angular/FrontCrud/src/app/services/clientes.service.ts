import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Clientes } from '../models/Clientes';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {
  rutaGlobal = "http://localhost:3306/banco/Clientes"
  constructor(private http: HttpClient) { }

  //Crear cliente
  crearCliente(cliente: Clientes){
    return this.http.post<Clientes>(this.rutaGlobal + "nuevo", cliente, {
      observe: "response"
    })
  }

  //Obtener cliente
  getClientes(){
    return this.http.get<Clientes[]>(this.rutaGlobal + "mostrar")
  }

  //Actualizar cliente
  actualizarCliente(cliente: Clientes){
    return this.http.post<Clientes>(this.rutaGlobal + "update", cliente, {
      observe: "response"
    })
    
  }

  //Eliminar cliente
  eliminarCliente(numDoc: number){
    return this.http.post<Boolean>(this.rutaGlobal + numDoc, {
      observe: "responde"
    })
  }
}
