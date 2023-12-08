import { Component } from '@angular/core';
import { Clientes } from '../../models/Clientes';
import { FormGroup, FormBuilder, Validators, FormControl, ReactiveFormsModule } from '@angular/forms';
import { ClientesService } from '../../services/clientes.service';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrl: './body.component.css'
})
export class BodyComponent {
  Clientes: Array<Clientes>
  formularioClientes: FormGroup
  display: boolean

  constructor(private fb: FormBuilder, private cService: ClientesService){
    this.Clientes = new Array<Clientes>()
    this.display = false
    this.formularioClientes = fb.group({
      numDoc: new FormControl("", [Validators.required]),
      Nombre: new FormControl("", [Validators.required]),
      Apellido: new FormControl("", [Validators.required]),
    })
  }

  //Crear cliente
  crearCliente(){
    if(this.formularioClientes.valid){
      let cliente = new Clientes()
      cliente.numDoc = this.formularioClientes.get("numDoc")?.value
      cliente.nombre = this.formularioClientes.get("nombre")?.value
      cliente.apellido = this.formularioClientes.get("apellido")?.value
      this.cService.crearCliente(cliente).subscribe(res => {
        this.getCliente()
        this.formularioClientes.reset()
      })
    }
  }

  //Get cliente
  getCliente(){
    this.cService.getClientes().subscribe(res =>{
      this.Clientes = res
    })
  }

  //Delete cliente
  deleteCliente(idCliente: number){
    this.cService.eliminarCliente(idCliente).subscribe(res =>{
      this.getCliente()
    })
  }

  //Actualizar cliente
  actualizarCliente(){
  if(this.formularioClientes.valid){
    let cliente = new Clientes()
    cliente.numDoc = this.formularioClientes.get("numDoc")?.value
    cliente.nombre = this.formularioClientes.get("nombre")?.value
    cliente.apellido = this.formularioClientes.get("apellido")?.value
    this.cService.actualizarCliente(cliente).subscribe(res => {
      this.getCliente()
      this.formularioClientes.reset()
      this.display = !this.display
    })
  }
  }


  activador(cliente: Clientes){
    this.formularioClientes.get("numDoc")?.setValue(cliente.numDoc)
    this.formularioClientes.get("nombre")?.setValue(cliente.nombre)
    this.formularioClientes.get("apellido")?.setValue(cliente.apellido)
    this.display = !this.display
  }

}
