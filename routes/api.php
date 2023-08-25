<?php

use App\Http\Controllers\Api\PrincipalController;
use App\Http\Controllers\Api\AuthController;
use App\Http\Controllers\Api\Cliente\ClienteController;
use App\Http\Controllers\Api\Administrador\AdministradorController;
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
    Route::get('/public/index', [PrincipalController::class, 'index'])->name('index');

    //Rutas de logeo
    Route::post('/auth/register', [AuthController::class, 'register'])->name('register');
    Route::get('/auth/login', [AuthController::class, 'login'])->name('login');

    //Rutas privadas
    Route::group(['middleware' => 'auth:sanctum'], function () {
        //Rutas de logeo
        Route::post('/auth/logout', [AuthController::class, 'logout'])->name('logout');

        //Rutas de cliente
        Route::apiResource('/cliente', ClienteController::class);

        //Rutas de administrador
        Route::apiResource('/administrador', AdministradorController::class);
    });
});

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});
