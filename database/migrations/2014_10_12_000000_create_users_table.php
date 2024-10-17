<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('users', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('trol_id');
            $table->unsignedBigInteger('tusuario_admin_id')->nullable();
            $table->unsignedBigInteger('tusuario_nutriologo_id')->nullable();
            $table->unsignedBigInteger('tusuario_paciente_id')->nullable();
            $table->string('nombre');
            $table->string('primer_apellido');
            $table->string('segundo_apellido');
            $table->string('usuario')->unique();
            $table->string('correo')->unique();
            $table->timestamp('email_verified_at')->nullable();
            $table->string('contrasenia');
            $table->integer('estado');
            $table->foreign('trol_id')->references('id')->on('trols');
            $table->foreign('tusuario_admin_id')->references('id')->on('tusuario_admins');
            $table->foreign('tusuario_nutriologo_id')->references('id')->on('tusuario_nutriologos');
            $table->foreign('tusuario_paciente_id')->references('id')->on('tusuario_pacientes');
            $table->rememberToken();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('users');
    }
};