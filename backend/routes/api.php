<?php

use App\Http\Controllers\CategoryGatewayController;
use App\Http\Controllers\ProductGatewayController;
use Illuminate\Support\Facades\Route;

Route::get('/products/min', [ProductGatewayController::class, 'stockMin']);
Route::apiResource('products', ProductGatewayController::class);
Route::apiResource('categories', CategoryGatewayController::class);
