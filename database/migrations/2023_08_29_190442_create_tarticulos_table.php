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
        Schema::create('tarticulos', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('nutriologo_id');
            $table->string('titulo');
            $table->text('contenido');
            $table->text('foto');
            $table->foreign('nutriologo_id')->references('id')->on('tusuario_nutriologos');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('tarticulos');
    }
};
