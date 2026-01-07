package it.defendimattia.backenddemo.specification;

import org.springframework.data.jpa.domain.Specification;

import it.defendimattia.backenddemo.model.Watch;

public class WatchSpecification {

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

    public static Specification<Watch> movementTypeContains(String movementType) {
        return (root, query, cb) -> {

            if (movementType == null) {
                return null;
            }

            return cb.like(cb.lower(root.get("movementType")),
                    "%" + movementType.toLowerCase() + "%");
        };
    }

    public static Specification<Watch> waterResistanceGreaterThanEqual(Short waterResistance) {
        return (root, query, cb) -> {

            if (waterResistance == null) {
                return null;
            }

            return cb.greaterThanOrEqualTo(root.get("waterResistance"), waterResistance);
        };
    }

    public static Specification<Watch> caseDiameterGreaterThanEqual(Double min) {
        return (root, query, cb) -> {

            if (min == null)
                return null;

            return cb.greaterThanOrEqualTo(root.get("caseDiameter"), min);
        };
    }

    public static Specification<Watch> caseDiameterLessThan(Double max) {
        return (root, query, cb) -> {

            if (max == null)
                return null;

            return cb.lessThan(root.get("caseDiameter"), max);
        };
    }

    public static Specification<Watch> diameterGreaterThanEqual(Double diameter) {
        return (root, query, cb) -> {

            if (diameter == null) {
                return null;
            }

            return cb.greaterThanOrEqualTo(root.get("diameter"), diameter);
        };
    }

    public static Specification<Watch> diameterLessThanEqual(Double diameter) {
        return (root, query, cb) -> {

            if (diameter == null) {
                return null;
            }

            return cb.lessThanOrEqualTo(root.get("diameter"), diameter);
        };
    }

    public static Specification<Watch> caseThicknessGreaterThanEqual(Double caseThickness) {
        return (root, query, cb) -> {

            if (caseThickness == null) {
                return null;
            }

            return cb.greaterThanOrEqualTo(root.get("caseThickness"), caseThickness);
        };
    }

    public static Specification<Watch> caseThicknessLessThanEqual(Double caseThickness) {
        return (root, query, cb) -> {

            if (caseThickness == null) {
                return null;
            }

            return cb.lessThanOrEqualTo(root.get("caseThickness"), caseThickness);
        };
    }

    public static Specification<Watch> bandWidthGreaterThanEqual(Double bandWidth) {
        return (root, query, cb) -> {

            if (bandWidth == null) {
                return null;
            }

            return cb.greaterThanOrEqualTo(root.get("bandWidth"), bandWidth);
        };
    }

    public static Specification<Watch> bandWidthLessThanEqual(Double bandWidth) {
        return (root, query, cb) -> {

            if (bandWidth == null) {
                return null;
            }

            return cb.lessThanOrEqualTo(root.get("bandWidth"), bandWidth);
        };
    }

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

    public static Specification<Watch> powerReserveGreaterThanEqual(Short powerReserve) {
        return (root, query, cb) -> {

            if (powerReserve == null) {
                return null;
            }

            return cb.greaterThanOrEqualTo(root.get("powerReserve"), powerReserve);
        };
    }

    public static Specification<Watch> priceLessThanEqual(Integer price) {
        return (root, query, cb) -> {

            if (price == null) {
                return null;
            }

            return cb.lessThanOrEqualTo(root.get("price"), price);
        };
    }
}
