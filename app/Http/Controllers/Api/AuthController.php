<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Tusuario_nutriologo;
use App\Models\User;
use Exception;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;

class AuthController extends Controller
{
    public function upload(Request $request)
    {
        try {
            if ($request->hasFile('image')) {
                $image = $request->file('image');
                $imageName = time() . '.' . $image->getClientOriginalExtension();
                $image->move(public_path('images'), $imageName);
                $imageUrl = asset('images/' . $imageName);

                // Aquí puedes guardar $imageUrl en tu base de datos

                return response()->json([
                    'status' => 200,
                    'message' => 'Imagen subida con éxito',
                    'path' => '/api/v1/auth/upload',
                    'timestamp' => now()->toDateTimeString(),
                    'url' => $imageUrl,
                ], 200);
            }

            return response()->json([
                'status' => 400,
                'message' => 'No se ha subido ninguna imagen',
                'path' => '/api/v1/auth/upload',
                'timestamp' => now()->toDateTimeString(),
                'data' => null
            ], 400);
        } catch (\Throwable $th) {
            return response()->json([
                'status' => 500,
                'message' => 'Error al subir la imagen',
                'path' => '/api/v1/auth/upload',
                'timestamp' => now()->toDateTimeString(),
                'error' => $th->getMessage()
            ], 500);
        }
    }

    public function register(Request $request)
    {
        try {
            // Validar los datos
            $validator = Validator::make($request->all(), [
                'nombre' => 'required|string|max:255',
                'primer_apellido' => 'required|string|max:255',
                'segundo_apellido' => 'required|string|max:255',
                'usuario' => 'required|string|max:255|unique:users',
                'correo' => 'required|string|email|max:255|unique:users',
                'contrasenia' => 'required|string|min:8',
                'trol_id' => 'required|int',
            ]);

            // Si la validación falla, devolver un mensaje de error
            if ($validator->fails()) {
                return response()->json([
                    'status' => 400,
                    'message' => 'Fallo al validar los datos',
                    'path' => '/api/v1/auth/register',
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

            // Variable para almacenar los datos del tipo de usuario creado
            $tipoUsuarioData = null;

            // Agregar el tipo de usuario al usuario
            switch ($request->trol_id) {
                case 1:
                    $tipoUsuarioData = $user->admin()->create([
                        'descripcion' => $request->descripcion,
                        'foto' => $request->foto,
                        'telefono' => $request->telefono,
                    ]);
                    break;
                case 2:
                    $tipoUsuarioData = $user->nutriologo()->create([
                        'descripcion' => $request->descripcion,
                        'foto' => $request->foto,
                        'direccion' => $request->direccion,
                        'telefono' => $request->telefono,
                        'cedula_profesional' => $request->cedula_profesional,
                    ]);
                    break;
                case 3:
                    $tipoUsuarioData = $user->paciente()->create([
                        'foto' => $request->foto,
                        'telefono' => $request->telefono,
                        'fecha_nacimiento' => $request->fecha_nacimiento,
                        'sexo' => $request->sexo,
                        'alergias' => $request->alergias,
                    ]);
                    break;
                default:
                    throw new Exception('Tipo de usuario no válido');
            }

            // Generar un token para el usuario
            $token = $user->createToken('Nutrilud')->plainTextToken;

            // Devolver una respuesta exitosa
            return response()->json([
                'status' => 200,
                'message' => 'Usuario creado con éxito',
                'token' => $token,
                'user' => $user,
                'tipo_usuario' => $tipoUsuarioData, // Agrega los datos del tipo de usuario aquí
                'path' => '/api/v1/auth/register',
                'timestamp' => now()->toDateTimeString()
            ], 200);
        } catch (\Throwable $th) {
            return response()->json([
                'status' => 500,
                'message' => 'Error al crear el usuario',
                'path' => '/api/v1/auth/register',
                'timestamp' => now()->toDateTimeString(),
                'error' => $th->getMessage()
            ], 500);
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
                    'message' => 'Fallo al validar los datos',
                    'status' => 400,
                    'path' => '/api/v1/auth/login',
                    'timestamp' => now()->toDateTimeString(),
                    'errors' => $validatorUser->errors()
                ], 401);
            }

            $user = User::where('usuario', $request->usuario)->first();

            if ($user && Hash::check($request->contrasenia, $user->contrasenia)) {
                // Las credenciales son correctas, generar token
                $token = $user->createToken('Nutrilud')->plainTextToken;

                // Devolver una respuesta exitosa
                return response()->json([
                    'status' => 200,
                    'message' => 'Inicio de sesión exitoso',
                    'token' => $token,
                    'user' => $user->id,
                    'admin_id' => $user->admin->id ?? null,
                    'nutriologo_id' => $user->nutriologo->id ?? null,
                    'paciente_id' => $user->paciente->id ?? null,
                    'trol_id' => $user->trol_id,
                    'path' => '/api/v1/auth/login',
                    'timestamp' => now()->toDateTimeString()
                ], 200);
            } else {
                // Las credenciales no son correctas, devolver error
                return response()->json([
                    'message' => 'Usuario y contraseña incorrectos',
                    'status' => 401,
                    'path' => '/api/v1/auth/login',
                    'timestamp' => now()->toDateTimeString()
                ], 401);
            }
        } catch (\Throwable $th) {
            return response()->json([
                'message' => $th->getMessage(),
                'status' => 500,
                'path' => '/api/v1/auth/login',
                'timestamp' => now()->toDateTimeString(),
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
                    'message' => 'Sesión cerrada con éxito',
                    'status' => 200,
                    'path' => '/api/v1/auth/logout',
                    'timestamp' => now()->toDateTimeString(),
                ], 200);
            } else {
                return response()->json([
                    'message' => 'No hay ninguna sesión activa',
                    'status' => 400,
                    'path' => '/api/v1/auth/logout',
                    'timestamp' => now()->toDateTimeString(),
                ], 400);
            }
        } catch (\Exception $exception) {
            logger()->error($exception->getMessage());

            return response()->json([
                'message' => 'Ocurrió un error al cerrar la sesión',
                'status' => 500,
                'path' => '/api/v1/auth/logout',
                'timestamp' => now()->toDateTimeString(),
                'error' => $exception->getMessage()
            ], 500);
        }
    }

    public function showDatos($id)
    {
        try {
            $nutriologoData = Tusuario_nutriologo::with('user')->find($id);

            if ($nutriologoData === null) {
                return response()->json([
                    'message' => 'Nutriologo no encontrado',
                    'status' => 400,
                    'path' => "/api/v1/auth/user/{$id}",
                    'timestamp' => now()->toDateTimeString(),
                    'data' => null
                ], 400);
            }

            // Utiliza response()->json() para enviar la respuesta JSON
            return response()->json([
                'message' => 'Datos del nutriologo',
                'status' => 200,
                'path' => "/api/v1/auth/user/{$id}",
                'timestamp' => now()->toDateTimeString(),
                'data' => $nutriologoData
            ], 200);
        } catch (\Throwable $e) {
            return response()->json([
                'message' => 'Error al obtener los datos del nutriologo',
                'status' => 500,
                'path' => "/api/v1/auth/user/{$id}",
                'timestamp' => now()->toDateTimeString(),
                'data' => $e->getMessage()
            ], 500);
        }
    }
}
