<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Validator;
use Laravel\Sanctum\HasApiTokens;

class AuthController extends Controller
{
    public function registrarAdmin(Request $request)
    {
        // Validar los campos ingresados
        $validator = Validator::make($request->all(), [
            // 'foto' => 'nullable|image|mimes:jpg,jpeg,png|max:10000',
            'nombre' => 'required|string|max:255',
            'primer_apellido' => 'required|string|max:255',
            'segundo_apellido' => 'required|string|max:255',
            'usuario' => 'required|string|max:255|unique:users',
            'correo' => 'required|string|email|max:255|unique:users',
            'contrasenia' => 'required|string|min:8',
            'descripcion' => 'required|string|max:255',
            'telefono' => 'required|int|min:10',
            'trol_id' => 'required|int'
        ]);

        // Si la validacion falla, devolver un mensaje de error
        if ($validator->fails()) {
            return response()->json([
                'status' => false,
                'message' => 'Fallo al validar los datos',
                'errors' => $validator->errors()
            ], 400);
        }

        // Crear un nuevo usuario
        $user = User::create([
            'trol_id' => $request->trol_id,
            'nombre' => $request->nombre,
            'primer_apellido' => $request->primer_apellido,
            'segundo_apellido' => $request->segundo_apellido,
            'usuario' => $request->usuario,
            'correo' => $request->correo,
            'contrasenia' => Hash::make($request->contrasenia),
            'estado' => 1,
        ]);

        if ($user) {

            $admin = $user->admin()->create([
                'descripcion' => $request->descripcion,
                'foto' => $request->foto, // 'foto' => $request->file('foto')->store('uploads'),
                'telefono' => $request->telefono,
            ]);

            // Devolver una respuesta exitosa
            return response()->json([
                'status' => true,
                'message' => 'Usuario creado con éxito',
                'user' => $user,
                'admin' => $admin,
                'token' => $user->createToken('Nutrilud')->plainTextToken,
            ], 200);
        } else {
            return response()->json([
                'status' => false,
                'message' => 'Fallo al crear el usuario',
            ], 400);
        }
    }

    public function registrarNutriologo(Request $request)
    {
        $validator = Validator::make($request->all(), [
            // 'foto' => 'nullable|image|mimes:jpg,jpeg,png|max:10000',
            'nombre' => 'required|string|max:255',
            'primer_apellido' => 'required|string|max:255',
            'segundo_apellido' => 'required|string|max:255',
            'usuario' => 'required|string|max:255|unique:users',
            'correo' => 'required|string|email|max:255|unique:users',
            'contrasenia' => 'required|string|min:8',
            'descripcion' => 'required|string|max:255',
            'telefono' => 'required|int|min:10',
            'trol_id' => 'required|int'
        ]);

        // Si la validacion falla, devolver un mensaje de error
        if ($validator->fails()) {
            return response()->json([
                'status' => false,
                'message' => 'Fallo al validar los datos',
                'errors' => $validator->errors()
            ], 400);
        }

        // Crear un nuevo usuario
        $user = User::create([
            'trol_id' => $request->trol_id,
            'nombre' => $request->nombre,
            'primer_apellido' => $request->primer_apellido,
            'segundo_apellido' => $request->segundo_apellido,
            'usuario' => $request->usuario,
            'correo' => $request->correo,
            'contrasenia' => Hash::make($request->contrasenia),
            'estado' => 1,
        ]);

        if ($user) {

            $nutriologo = $user->nutriologo()->create([
                'descripcion' => $request->descripcion,
                'foto' => $request->foto,
                'direccion' => $request->direccion,
                'telefono' => $request->telefono,
                'cedula_profesional' => $request->cedula_profesional,
            ]);

            // Devolver una respuesta exitosa
            return response()->json([
                'status' => true,
                'message' => 'Usuario creado con éxito',
                'user' => $user,
                'nutriologo' => $nutriologo,
                'token' => $user->createToken('Nutrilud')->plainTextToken,
            ], 200);
        } else {
            return response()->json([
                'status' => false,
                'message' => 'Fallo al crear el usuario',
            ], 400);
        }
    }

    public function registrarPaciente(Request $request)
    {
        $validator = Validator::make($request->all(), [
            // 'foto' => 'nullable|image|mimes:jpg,jpeg,png|max:10000',
            'nombre' => 'required|string|max:255',
            'primer_apellido' => 'required|string|max:255',
            'segundo_apellido' => 'required|string|max:255',
            'usuario' => 'required|string|max:255|unique:users',
            'correo' => 'required|string|email|max:255|unique:users',
            'contrasenia' => 'required|string|min:8',
            'fecha_nacimiento' => 'required|date',
            'telefono' => 'required|int|min:10',
            'trol_id' => 'required|int'
        ]);

        // Si la validacion falla, devolver un mensaje de error
        if ($validator->fails()) {
            return response()->json([
                'status' => false,
                'message' => 'Fallo al validar los datos',
                'errors' => $validator->errors()
            ], 400);
        }

        // Crear un nuevo usuario
        $user = User::create([
            'trol_id' => $request->trol_id,
            'nombre' => $request->nombre,
            'primer_apellido' => $request->primer_apellido,
            'segundo_apellido' => $request->segundo_apellido,
            'usuario' => $request->usuario,
            'correo' => $request->correo,
            'contrasenia' => Hash::make($request->contrasenia),
            'estado' => 1,
        ]);

        if ($user) {

            $paciente = $user->paciente()->create([
                'foto' => $request->foto,
                'telefono' => $request->telefono,
                'fecha_nacimiento' => $request->fecha_nacimiento,
                'sexo' => $request->sexo,
                'alergias' => $request->alergias,
            ]);

            return response()->json([
                'status' => true,
                'message' => 'Usuario creado con éxito',
                'user' => $user,
                'paciente' => $paciente,
                'token' => $user->createToken('Nutrilud')->plainTextToken,
            ], 200);
        } else {
            return response()->json([
                'status' => false,
                'message' => 'Fallo al crear el usuario',
            ], 400);
        }
    }

    public function login(Request $request)
    {
        try {
            $validatorUser = Validator::make(
                request()->all(),
                [
                    'usuario' => 'required',
                    'contrasenia' => 'required'
                ]
            );

            if ($validatorUser->fails()) {
                return response()->json([
                    'status' => false,
                    'message' => 'Fallo al validar los datos',
                    'errors' => $validatorUser->errors()
                ], 401);
            }

            $user = User::where('usuario', $request->usuario)->first();

            if ($user && Hash::check($request->contrasenia, $user->contrasenia)) {
                // Las credenciales son correctas, generar token
                $token = $user->createToken('Nutrilud')->plainTextToken;

                // Devolver una respuesta exitosa
                return response()->json([
                    'status' => true,
                    'message' => 'Inicio de sesión exitoso',
                    'token' => $token,
                    'user' => $user->id,
                    'admin_id' => $user->admin->id ?? null,
                    'nutriologo_id' => $user->nutriologo->id ?? null,
                    'paciente_id' => $user->paciente->id ?? null,
                    'trol_id' => $user->trol_id,
                ], 200);
            } else {
                // Las credenciales no son correctas, devolver error
                return response()->json([
                    'status' => false,
                    'message' => 'Usuario y contraseña incorrectos'
                ], 401);
            }
        } catch (\Throwable $th) {
            return response()->json([
                'status' => false,
                'message' => $th->getMessage()
            ], 500);
        }
    }

    public function logout(Request $request)
    {
        try {
            $user = $request->user();

            if ($user) {
                $user->tokens->each(function ($token, $key) {
                    $token->delete();
                });

                return response()->json([
                    'status' => true,
                    'message' => 'Sesión cerrada con éxito'
                ], 200);
            } else {
                return response()->json([
                    'status' => false,
                    'message' => 'No hay ninguna sesión activa'
                ], 400);
            }
        } catch (\Exception $exception) {
            logger()->error($exception->getMessage());

            return response()->json([
                'status' => false,
                'message' => 'Ocurrió un error al cerrar la sesión'
            ], 500);
        }
    }
}
