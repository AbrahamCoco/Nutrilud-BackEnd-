<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;

class AuthController extends Controller
{
    public function register(Request $request)
    {
        //Validar los campos ingresados
        $validator = Validator::make($request->all(), [
            'name' => 'required|string|max:255',
            'email' => 'required|string|email|unique:users|max:255',
            'password' => 'required|string|min:8'
        ]);

        //Si la validacion falla, devolver un mensaje de error
        if ($validator->fails()) {
            return response()->json([
                'message' => 'Fallo al validar los datos',
                'errors' => $validator->errors()
            ], 400);
        }

        //Crear un nuevo usuario
        $user = User::create([
            'name' => $request->name,
            'email' => $request->email,
            //Encriptar la contraseña
            'password' => Hash::make($request->password)
        ]);

        //Devolver un mensaje de exito
        return response()->json([
            'message' => 'Usuario creado con exito',
            'user' => $user
        ], 200);
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
