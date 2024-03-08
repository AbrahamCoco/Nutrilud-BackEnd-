<?php

namespace Database\Seeders;

use App\Models\Tusuario_admin;
use App\Models\Tusuario_nutriologo;
use App\Models\User;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\Hash;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     *
     * @return void
     */
    public function run()
    {
        // Luego, crear el usuario asociado a ese nutriólogo
        $nutriologo = User::create([
            'trol_id' => 2, // Asumiendo que 2 es el ID del rol de nutriólogo
            'nombre' => 'Karina',
            'primer_apellido' => 'Netzahualcoyotl',
            'segundo_apellido' => 'Acoltzi',
            'usuario' => 'karina',
            'correo' => 'karina@gmail.com',
            'contrasenia' => Hash::make('karina1994'),
            'estado' => 1,
        ]);

        // Crear un usuario nutriólogo primero
        Tusuario_nutriologo::create([
            'descripcion' => 'Nutriologa',
            'foto' => 'http://127.0.0.1:8000/images/1708140145.jpg',
            'direccion' => 'Calle 5 de mayo, Contla de Juan Cuamatzi, Tlaxcala',
            'telefono' => '246 465 7890',
            'cedula_profesional' => '20242271',
            'user_id' => $nutriologo->id,
        ]);

        $admin = User::create([
            'trol_id' => 1,
            'nombre' => 'Abraham',
            'primer_apellido' => 'Cocoletzi',
            'segundo_apellido' => 'Zempoalteca',
            'usuario' => 'abraham',
            'correo' => 'abraham@gmail.com',
            'contrasenia' => Hash::make('abraham1995'),
            'estado' => 1,
        ]);

        Tusuario_admin::create([
            'descripcion' => 'Administrador',
            'foto' => 'http://127.0.0.1:8000/images/1708140145.jpg',
            'telefono' => '246 465 7890',
            'user_id' => $admin->id,
        ]);
    }
}
