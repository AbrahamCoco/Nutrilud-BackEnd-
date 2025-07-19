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
        Schema::create('tdatarecordatorio', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('t_recordatorio_id');
            $table->string("comida");
            $table->string("hora")->nullable();
            $table->string("lugar")->nullable();
            $table->string("alimentos")->nullable();
            $table->string("porciones")->nullable();
            $table->string("marca")->nullable();
            $table->string("preparacion")->nullable();
            $table->foreign('t_recordatorio_id')->references('id')->on('t_recordatorios');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('tdatarecordatorio');
    }
};
