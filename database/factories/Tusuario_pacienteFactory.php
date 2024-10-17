<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Tusuario_paciente>
 */
class Tusuario_pacienteFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'foto' => $this->faker->imageUrl(),
            'telefono' => $this->faker->phoneNumber(),
            'fecha_nacimiento' => $this->faker->date(),
            'sexo' => $this->faker->randomElement(['Masculino', 'Femenino']),
            'alergias' => $this->faker->text(100),
        ];
    }
}
