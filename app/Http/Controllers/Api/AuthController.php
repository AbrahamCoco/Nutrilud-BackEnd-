<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Tusuario_admin;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;

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
                'foto' => $request->foto,
                'telefono' => $request->telefono,
            ]);

            // Devolver una respuesta exitosa
            return response()->json([
                'message' => 'Usuario creado con éxito',
                'user' => $user,
                'admin' => $admin
            ], 200);
        } else {
            return response()->json([
                'message' => 'Fallo al crear el usuario',
            ], 400);
        }
    }

    public function login()
    {
        return response()->json([
            'message' => 'login'
        ]);
    }

    public function logout()
    {
        return response()->json([
            'message' => 'logout'
        ]);
    }
}
