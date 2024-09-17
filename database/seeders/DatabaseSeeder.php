<?php

namespace Database\Seeders;

use App\Models\Tarticulos;
use App\Models\Trol;
use App\Models\Tusuario_admin;
use App\Models\Tusuario_nutriologo;
use App\Models\Tusuario_paciente;
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
        Trol::create([
            'rol' => 'Administrador',
            'estado' => 1,
        ]);

        Trol::create([
            'rol' => 'Nutriologo',
            'estado' => 1,
        ]);

        Trol::create([
            'rol' => 'Paciente',
            'estado' => 1,
        ]);

        $nutriologo = Tusuario_nutriologo::create([
            'descripcion' => 'Nutriologa',
            'foto' => null,
            'direccion' => 'Calle 5 de mayo, Contla de Juan Cuamatzi, Tlaxcala',
            'telefono' => '246 465 7890',
            'cedula_profesional' => '20242271',
        ]);

        User::create([
            'trol_id' => 2,
            'tusuario_nutriologo_id' => $nutriologo->id,
            'nombre' => 'Karina',
            'primer_apellido' => 'Netzahualcoyotl',
            'segundo_apellido' => 'Acoltzi',
            'usuario' => 'karina',
            'correo' => 'karina@gmail.com',
            'contrasenia' => Hash::make('karina1994'),
            'estado' => 1,
        ]);

        $admin = Tusuario_admin::create([
            'descripcion' => 'Administrador',
            'foto' => null,
            'telefono' => '246 465 7890',
        ]);

        User::create([
            'trol_id' => 1,
            'tusuario_admin_id' => $admin->id,
            'nombre' => 'Abraham',
            'primer_apellido' => 'Cocoletzi',
            'segundo_apellido' => 'Zempoalteca',
            'usuario' => 'abraham',
            'correo' => 'abraham@gmail.com',
            'contrasenia' => Hash::make('abraham1995'),
            'estado' => 1,
        ]);

        $paciente = Tusuario_paciente::create([
            'foto' => null,
            'telefono' => '246 465 7890',
            'fecha_nacimiento' => '1996-08-27',
            'sexo' => 'Masculino',
            'alergias' => 'Ninguna',
        ]);

        User::create([
            'trol_id' => 3,
            'tusuario_paciente_id' => $paciente->id,
            'nombre' => 'Juan',
            'primer_apellido' => 'Perez',
            'segundo_apellido' => 'Gonzalez',
            'usuario' => 'juan',
            'correo' => 'juan@gmail.com',
            'contrasenia' => Hash::make('juan1996'),
            'estado' => 1,
        ]);

        Tarticulos::create([
            'nutriologo_id' => $nutriologo->id,
            'contenido' => '<h3>La Importancia de una Nutrici&oacute;n Saludable</h3>
 <p>La nutrici&oacute;n saludable es fundamental para mantener un cuerpo y mente sanos. Una dieta equilibrada proporciona los nutrientes necesarios para el correcto funcionamiento del organismo, previniendo enfermedades y mejorando la calidad de vida.</p>
 <h4>Principios B&aacute;sicos de una Alimentaci&oacute;n Saludable</h4>
 <ol>
 <li><strong>Variedad de Alimentos</strong>: Consumir una amplia gama de alimentos asegura que el cuerpo reciba todos los nutrientes esenciales. Incluye frutas, verduras, prote&iacute;nas magras, granos enteros y l&aacute;cteos bajos en grasa.</li>
 <li><strong>Control de Porciones</strong>: Comer en cantidades adecuadas ayuda a mantener un peso saludable y evita el consumo excesivo de calor&iacute;as.</li>
 <li><strong>Reducci&oacute;n de Az&uacute;cares y Grasas Saturadas</strong>: Limitar el consumo de az&uacute;cares a&ntilde;adidos y grasas saturadas reduce el riesgo de enfermedades cr&oacute;nicas como la diabetes y las enfermedades card&iacute;acas.</li>
 <li><strong>Hidrataci&oacute;n Adecuada</strong>: Beber suficiente agua es crucial para mantener la hidrataci&oacute;n y apoyar las funciones corporales.</li>
 </ol>
 <h4>Beneficios de una Buena Nutrici&oacute;n</h4>
 <ul>
 <li><strong>Mejora del Sistema Inmunol&oacute;gico</strong>: Una dieta rica en vitaminas y minerales fortalece el sistema inmunol&oacute;gico, ayudando al cuerpo a combatir infecciones.</li>
 <li><strong>Aumento de Energ&iacute;a</strong>: Los alimentos nutritivos proporcionan la energ&iacute;a necesaria para las actividades diarias.</li>
 <li><strong>Salud Mental</strong>: Una buena nutrici&oacute;n tambi&eacute;n est&aacute; vinculada a una mejor salud mental, reduciendo el riesgo de depresi&oacute;n y ansiedad.</li>
 <li><strong>Prevenci&oacute;n de Enfermedades</strong>: Mantener una dieta equilibrada puede prevenir enfermedades cr&oacute;nicas como la obesidad, la hipertensi&oacute;n y ciertos tipos de c&aacute;ncer.</li>
 </ul>
 <h4>Consejos Pr&aacute;cticos para una Alimentaci&oacute;n Saludable</h4>
 <ul>
 <li><strong>Planificaci&oacute;n de Comidas</strong>: Planificar las comidas con anticipaci&oacute;n puede ayudar a hacer elecciones m&aacute;s saludables y evitar la tentaci&oacute;n de alimentos poco nutritivos.</li>
 <li><strong>Leer Etiquetas</strong>: Aprender a leer las etiquetas de los alimentos puede ayudar a identificar ingredientes no deseados y elegir opciones m&aacute;s saludables.</li>
 <li><strong>Cocinar en Casa</strong>: Preparar comidas en casa permite controlar los ingredientes y las porciones, asegurando una dieta m&aacute;s saludable.</li>
 </ul>
 <p>Adoptar h&aacute;bitos de alimentaci&oacute;n saludable no solo mejora la salud f&iacute;sica, sino tambi&eacute;n la mental y emocional. &iexcl;Empieza hoy a hacer peque&ntilde;os cambios en tu dieta y disfruta de los beneficios a largo plazo!</p>',
            'foto' => "http://127.0.0.1:8000/images/1725556518.jpeg",
        ]);

        Tusuario_paciente::factory(50)->create()->each(function ($paciente) {
            User::factory()->create([
                'trol_id' => 3,
                'tusuario_paciente_id' => $paciente->id,
            ]);
        });

        Tusuario_nutriologo::factory(20)->create()->each(function ($nutriologo) {
            User::factory()->create([
                'trol_id' => 2,
                'tusuario_nutriologo_id' => $nutriologo->id,
            ]);
        });

        Tusuario_admin::factory(3)->create()->each(function ($admin) {
            User::factory()->create([
                'trol_id' => 1,
                'tusuario_admin_id' => $admin->id,
            ]);
        });
    }
}
