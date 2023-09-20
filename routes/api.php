<?php

use App\Http\Controllers\Api\ArticulosController;
use App\Http\Controllers\Api\AuthController;
use App\Http\Controllers\Api\Paciente\PacienteController;
use App\Http\Controllers\Api\Administrador\AdministradorController;
use App\Http\Controllers\Api\Nutriologo\NutriologoController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

Route::prefix('v1')->group(function () {
    //Rutas publicas
    Route::get('/', [ArticulosController::class, 'index'])->name('index');
    Route::get('/articulo/{id}', [ArticulosController::class, 'show'])->name('show');

    //Rutas de registro y logeo
    Route::post('/auth/registrarAdmin', [AuthController::class, 'registrarAdmin'])->name('registrarAdmin');
    Route::post('/auth/registrarNutriologo', [AuthController::class, 'registrarNutriologo'])->name('registrarNutriologo');
    Route::post('/auth/registrarPaciente', [AuthController::class, 'registrarPaciente'])->name('registrarPaciente');

    // Route::post('/auth/loginAdmin', [AuthController::class, 'loginAdmin'])->name('loginAdmin');
    // Route::post('/auth/loginNutriologo', [AuthController::class, 'loginNutriologo'])->name('loginNutriologo');
    // Route::post('/auth/loginPaciente', [AuthController::class, 'loginPaciente'])->name('loginPaciente');
    Route::post('/auth/login', [AuthController::class, 'login'])->name('login');

    Route::post('/nutriologo/articulos', [ArticulosController::class, 'store'])->name('store');

    //Rutas privadas
    Route::middleware('auth:sanctum')->group(function () {
        //Rutas de logeo
        Route::post('/auth/logout', [AuthController::class, 'logout'])->name('logout');

        //Rutas de paciente
        Route::apiResource('/paciente', PacienteController::class);

        //Rutas de nutriologo
        Route::apiResource('/nutriologo', NutriologoController::class);
        // Route::post('/nutriologo/articulos', [ArticulosController::class, 'store'])->name('store');

        //Rutas de administrador
        Route::apiResource('/administrador', AdministradorController::class);
    });
});

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});
