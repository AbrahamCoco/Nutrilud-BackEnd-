<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Tusuario_nutriologo>
 */
class Tusuario_nutriologoFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'descripcion' => $this->faker->sentence(),
            'foto' => $this->faker->imageUrl(),
            'direccion' => $this->faker->address(),
            'telefono' => $this->faker->phoneNumber(),
            'cedula_profesional' => $this->faker->numerify('########'),
        ];
    }
}
