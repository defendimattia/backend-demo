package it.defendimattia.backenddemo.specification;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import it.defendimattia.backenddemo.model.Watch;

/**
 * Provides JPA {@link Specification} objects to filter {@link Watch} entities
 * based on different search criteria.
 *
 * <p>
 * Each method returns a Specification that can be combined with others using
 * {@code and()} / {@code or()} in repository queries. Null parameters are
 * ignored.
 * </p>
 */
public class WatchSpecification {

    /**
     * Filters watches whose brand contains the given string (case-insensitive).
     *
     * @param brand the brand to filter by
     * @return a {@link Specification} for brand filtering, or null if brand is null
     */
    public static Specification<Watch> brandContains(String brand) {
        return (root, query, cb) -> {

            if (brand == null) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get("brand")),
                    "%" + brand.toLowerCase() + "%");
        };
    }

    /**
     * Filters watches whose model contains the given string (case-insensitive).
     *
     * @param model the model to filter by
     * @return a {@link Specification} for model filtering, or null if model is null
     */
    public static Specification<Watch> modelContains(String model) {
        return (root, query, cb) -> {

            if (model == null) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get("model")),
                    "%" + model.toLowerCase() + "%");
        };
    }

    /**
     * Filters watches by case material (contains, case-insensitive).
     */
    public static Specification<Watch> caseMaterialContains(String caseMaterial) {
        return (root, query, cb) -> {

            if (caseMaterial == null) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get("caseMaterial")),
                    "%" + caseMaterial.toLowerCase() + "%");
        };
    }

    /**
     * Filters watches by strap material (contains, case-insensitive).
     */
    public static Specification<Watch> strapMaterialContains(String strapMaterial) {
        return (root, query, cb) -> {

            if (strapMaterial == null) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get("strapMaterial")),
                    "%" + strapMaterial.toLowerCase() + "%");
        };
    }

    /**
     * Filters watches by movement type (contains, case-insensitive).
     */
    public static Specification<Watch> movementTypeContains(String movementType) {
        return (root, query, cb) -> {

            if (movementType == null) {
                return null;
            }

            return cb.like(cb.lower(root.get("movementType")),
                    "%" + movementType.toLowerCase() + "%");
        };
    }

    /**
     * Filters watches with water resistance greater than or equal to the given
     * value.
     */
    public static Specification<Watch> waterResistanceGreaterThanEqual(Short waterResistance) {
        return (root, query, cb) -> {

            if (waterResistance == null) {
                return null;
            }

            return cb.greaterThanOrEqualTo(root.get("waterResistance"), waterResistance);
        };
    }

    /**
     * Filters watches with case diameter greater than or equal to the given value.
     */
    public static Specification<Watch> caseDiameterGreaterThanEqual(BigDecimal min) {
        return (root, query, cb) -> {

            if (min == null)
                return null;

            return cb.greaterThanOrEqualTo(root.get("caseDiameter"), min);
        };
    }

    /**
     * Filters watches with case diameter less than the given value.
     */
    public static Specification<Watch> caseDiameterLessThan(BigDecimal max) {
        return (root, query, cb) -> {

            if (max == null)
                return null;

            return cb.lessThan(root.get("caseDiameter"), max);
        };
    }

    /**
     * Filters watches with case thickness greater than or equal to the given value.
     */
    public static Specification<Watch> caseThicknessGreaterThanEqual(BigDecimal caseThickness) {
        return (root, query, cb) -> {

            if (caseThickness == null) {
                return null;
            }

            return cb.greaterThanOrEqualTo(root.get("caseThickness"), caseThickness);
        };
    }

    /**
     * Filters watches with case thickness less than or equal to the given value.
     */
    public static Specification<Watch> caseThicknessLessThanEqual(BigDecimal caseThickness) {
        return (root, query, cb) -> {

            if (caseThickness == null) {
                return null;
            }

            return cb.lessThanOrEqualTo(root.get("caseThickness"), caseThickness);
        };
    }

    /**
     * Filters watches with band width greater than or equal to the given value.
     */
    public static Specification<Watch> bandWidthGreaterThanEqual(BigDecimal bandWidth) {
        return (root, query, cb) -> {

            if (bandWidth == null) {
                return null;
            }

            return cb.greaterThanOrEqualTo(root.get("bandWidth"), bandWidth);
        };
    }

    /**
     * Filters watches with band width less than or equal to the given value.
     */
    public static Specification<Watch> bandWidthLessThanEqual(BigDecimal bandWidth) {
        return (root, query, cb) -> {

            if (bandWidth == null) {
                return null;
            }

            return cb.lessThanOrEqualTo(root.get("bandWidth"), bandWidth);
        };
    }

    /**
     * Filters watches by dial color (contains, case-insensitive).
     */
    public static Specification<Watch> dialColorContains(String dialColor) {
        return (root, query, cb) -> {

            if (dialColor == null) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get("dialColor")),
                    "%" + dialColor.toLowerCase() + "%");
        };
    }

    /**
     * Filters watches by crystal material (contains, case-insensitive).
     */
    public static Specification<Watch> crystalMaterialContains(String crystalMaterial) {
        return (root, query, cb) -> {

            if (crystalMaterial == null) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get("crystalMaterial")),
                    "%" + crystalMaterial.toLowerCase() + "%");
        };
    }

    /**
     * Filters watches by complications (contains, case-insensitive).
     */
    public static Specification<Watch> complicationsContains(String complications) {
        return (root, query, cb) -> {

            if (complications == null) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get("complications")),
                    "%" + complications.toLowerCase() + "%");
        };
    }

    /**
     * Filters watches with power reserve greater than or equal to the given value.
     */
    public static Specification<Watch> powerReserveGreaterThanEqual(Short powerReserve) {
        return (root, query, cb) -> {

            if (powerReserve == null) {
                return null;
            }

            return cb.greaterThanOrEqualTo(root.get("powerReserve"), powerReserve);
        };
    }

    /**
     * Filters watches with price less than or equal to the given value.
     */
    public static Specification<Watch> priceLessThanEqual(Integer price) {
        return (root, query, cb) -> {

            if (price == null) {
                return null;
            }

            return cb.lessThanOrEqualTo(root.get("price"), price);
        };
    }
}
