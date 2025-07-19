<?php

namespace Database\Factories;

use App\Models\User;
use Illuminate\Database\Eloquent\Factories\Factory;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Str;

class UserFactory extends Factory
{
    protected $model = User::class;

    public function definition()
    {
        return [
            'trol_id' => $this->faker->randomElement([1, 2, 3]), // Rol: Admin(1), Nutriólogo(2), Paciente(3)
            'nombre' => $this->faker->firstName(),
            'primer_apellido' => $this->faker->lastName(),
            'segundo_apellido' => $this->faker->lastName(),
            'usuario' => $this->faker->userName(),
            'correo' => $this->faker->unique()->safeEmail(),
            'contrasenia' => 'password', // Contraseña por defecto
            'estado' => 1, // Estado por defecto
        ];
    }
}
