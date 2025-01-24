package controller;

public class ProductController public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Hozzáadás: POST /api/products
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product saved = productService.addProduct(product);
        return ResponseEntity.ok(saved);
    }

    // Módosítás: PUT /api/products/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
                                                 @RequestBody Product product) {
        Product updated = productService.updateProduct(id, product);
        return ResponseEntity.ok(updated);
    }

    // Törlés: DELETE /api/products/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<Product>> listProducts(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        Page<Product> products = productService.listProducts(PageRequest.of(page, size));
        return ResponseEntity.ok(products);
    }



    // Árszerinti szűrés
    @GetMapping("/filter")
    public ResponseEntity<Page<Product>> filterByPrice(@RequestParam double min,
                                                       @RequestParam double max,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        Page<Product> filtered = productService.filterByPrice(min, max, PageRequest.of(page, size));
        return ResponseEntity.ok(filtered);
    }
}

