<?php

namespace App\Http\Controllers;

use App\Utils\ErrorHandler;
use Error;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class ProductGatewayController extends Controller
{

    private string $baseUrl;
    private ErrorHandler $errorHandler;

    /**
     * Constructor.
     * Inicializa la URL base de la API para la gestión de productos.
     */
    public function __construct(ErrorHandler $errorHandler)
    {
        $this->baseUrl = config('services.stock_api_url') . '/api/products';
        $this->errorHandler = $errorHandler;
    }

    /**
     * Mostrar una lista de todos los productos.
     * Realiza una solicitud GET a la API externa para obtener la lista de productos.
     *
     * @return JsonResponse
     */
    public function index(): JsonResponse
    {
        try {
            $response = Http::get($this->baseUrl);
            return response()->json($response->json(), $response->status());
        } catch (\Exception $e) {
            return $this->errorHandler->handleServiceUnavailable();
        }
    }

    /**
     * Crear un nuevo producto y almacenarlo en la base de datos.
     * Realiza una solicitud POST a la API externa para crear un nuevo producto.
     *
     * @param Request $request
     * @return JsonResponse
     */
    public function store(Request $request): JsonResponse
    {
        try {
            $response = Http::post($this->baseUrl, $request->all());
            return response()->json($response->json(), $response->status());
        } catch (\Exception $e) {
            return $this->errorHandler->handleServiceUnavailable();
        }
    }

    /**
     * Mostrar el producto especificado.
     * Realiza una solicitud GET a la API externa para obtener los detalles de un producto específico.
     *
     * @param string $id
     * @return JsonResponse
     */
    public function show(string $id): JsonResponse
    {
        try {
            $response = Http::get($this->baseUrl . '/' . $id);
            return response()->json($response->json(), $response->status());
        } catch (\Exception $e) {
            return $this->errorHandler->handleServiceUnavailable();
        }
    }

    /**
     * Actualizar el producto especificado.
     * Realiza una solicitud PUT a la API externa para actualizar un producto específico.
     *
     * @param Request $request
     * @param string $id
     * @return JsonResponse
     */
    public function update(Request $request, string $id): JsonResponse
    {
        try {
            $response = Http::put($this->baseUrl . '/' . $id, $request->all());
            return response()->json($response->json(), $response->status());
        } catch (\Exception $e) {
            return $this->errorHandler->handleServiceUnavailable();
        }
    }

    /**
     * Eliminar el producto especificado.
     * Realiza una solicitud DELETE a la API externa para eliminar un producto específico.
     *
     * @param string $id
     * @return JsonResponse
     */
    public function destroy(string $id): JsonResponse
    {
        try {
            $response = Http::delete($this->baseUrl . '/' . $id);
            return response()->json($response->json(), $response->status());
        } catch (\Exception $e) {
            return $this->errorHandler->handleServiceUnavailable();
        }
    }

    /**
     * Mostrar el stock mínimo de productos.
     * Realiza una solicitud GET a la API externa para obtener el stock mínimo de productos.
     *
     * @return JsonResponse
     */
    public function stockMin(): JsonResponse
    {
        try {
            $response = Http::get($this->baseUrl . '/min');
            return response()->json($response->json(), $response->status());
        } catch (\Exception $e) {
            return $this->errorHandler->handleServiceUnavailable();
        }
    }
}
