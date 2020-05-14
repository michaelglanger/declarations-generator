package com.c4t.tools.decgen;

import com.c4t.tools.decgen.elements.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@Setter @Getter
public class Builder {

    private static Logger LOG = LoggerFactory.getLogger(Builder.class);

    @Value("${output.dir}")
    private String outputDir;

    @Value("${country}")
    private String country;

    @Value("${instancesToCreatePerDay}")
    private int instancesToCreate;

    @Value("${instancesToCreatePerDay_end}")
    private int instancesToCreateEnd;

    @Value("${accDateCodeInit}")
    private String accDateCodeInit;

    @Value("${accDateCodeEnd}")
    private String accDateCodeEnd;

    @Value("${externalReferenceInit}")
    private int externalReferenceInit;

    @Value("${externalReferenceDigits}")
    private int externalReferenceDigits;

    @Value("${version}")
    private String version;

    @Value("${direction}")
    private String direction;

    @Value("${externalReferenceRoot}")
    private String externalReferenceRoot;

    @Value("${messageType}")
    private String messageType;

    @Value("${storageLocationReference}")
    private String storageLocationReference;

    // SAD
    @Value("${sad.addDeclType1}")
    private String addDeclType1;

    // TODO this is a list
    @Value("${sad.additionalInformations_code}")
    private String additionalInformations_code;


    @Value("${sad.additionalInformations_text}")
    private String additionalInformations_text;

    @Value("${sad.additionalInformations_type}")
    private String additionalInformations_type;

    @Value("${sad.agentStatus}")
    private String agentStatus;

    @Value("${sad.declarationOfficeCode}")
    private String declarationOfficeCode;

    @Value("${sad.declType}")
    private String declType; // "IM", "EX"

    @Value("${sad.docRefNum_root}")
    private String docRefNum_root;

    @Value("${sad.invoiceCurrency}")
    private String invoiceCurrency;

    @Value("${sad.declarant_code}")
    private String declarant_code;

    @Value("${sad.goodsShipment.trxNatCode}")
    private int goodsShipment_trxNatCode;

    @Value("${sad.goodsShipment.customsValuation_present}")
    private boolean goodsShipment_customsValuation_present;

    @Value("${sad.goodsShipment.consignment.borderTransportMeans_identification}")
    private String goodsShipment_consignment_borderTransportMeans_identification;

    @Value("${sad.goodsShipment.consignment.borderTransportMeans_mode}")
    private String goodsShipment_consignment_borderTransportMeans_mode;

    @Value("${sad.goodsShipment.consignment.arrivalTransportMeans_identification}")
    private String goodsShipment_consignment_arrivalTransportMeans_identification;

    @Value("${sad.goodsShipment.consignment.arrivalTransportMeans_mode}")
    private String goodsShipment_consignment_arrivalTransportMeans_mode;

    @Value("${sad.goodsShipment.customsValuation.valuationMethod}")
    private String goodsShipment_customsValuation_valuationMethod;

    @Value("${sad.goodsShipment.tradeTerms_place}")
    private String goodsShipment_tradeTerms_place;

    @Value("${sad.goodsShipment.tradeTerms_termCode}")
    private String goodsShipment_tradeTerms_termCode;

    @Value("${sad.governmentAgencyGoodsItems.containerIdentification_present}")
    private boolean governmentAgencyGoodsItems_containerIdentification_present;

    @Value("${sad.governmentAgencyGoodsItems.containerIdentification_root}")
    private String governmentAgencyGoodsItems_containerIdentification_root;

    // TODO this is a list
    @Value("${sad.governmentAgencyGoodsItems.additionalDocuments_category}")
    private String governmentAgencyGoodsItems_additionalDocuments_category;

    @Value("${sad.governmentAgencyGoodsItems.additionalDocuments_refNum_root}")
    private String governmentAgencyGoodsItems_additionalDocuments_refNum_root;

    @Value("${sad.governmentAgencyGoodsItems.additionalDocuments_type}")
    private String governmentAgencyGoodsItems_additionalDocuments_type;

    @Value("${sad.governmentAgencyGoodsItems.commodity.invoiceLine.itemAmount_min}")
    private String governmentAgencyGoodsItems_commodity_invoiceLine_itemAmount_min;

    @Value("${sad.governmentAgencyGoodsItems.commodity.invoiceLine.itemAmount_increment}")
    private String governmentAgencyGoodsItems_commodity_invoiceLine_itemAmount_increment;

    @Value("${sad.governmentAgencyGoodsItems.commodity.invoiceLine.itemAmount_max}")
    private String governmentAgencyGoodsItems_commodity_invoiceLine_itemAmount_max;

    @Value("${sad.governmentAgencyGoodsItems.goodsMeasure.mass_min}")
    private int governmentAgencyGoodsItems_goodsMeasure_mass_min;

    @Value("${sad.governmentAgencyGoodsItems.goodsMeasure.mass_increment}")
    private int governmentAgencyGoodsItems_goodsMeasure_mass_increment; // not used

    @Value("${sad.governmentAgencyGoodsItems.goodsMeasure.mass_max}")
    private int governmentAgencyGoodsItems_goodsMeasure_mass_max;

    @Value("${sad.governmentAgencyGoodsItems.goodsMeasure.qty_min}")
    private int governmentAgencyGoodsItems_goodsMeasure_qty_min;

    @Value("${sad.governmentAgencyGoodsItems.goodsMeasure.qty_increment}")
    private int governmentAgencyGoodsItems_goodsMeasure_qty_increment;

    @Value("${sad.governmentAgencyGoodsItems.goodsMeasure.qty_max}")
    private int governmentAgencyGoodsItems_goodsMeasure_qty_max;

    @Value("${sad.governmentAgencyGoodsItems.governmentProcedure.proc}")
    private String governmentAgencyGoodsItems_governmentProcedure_proc;

    @Value("${sad.governmentAgencyGoodsItems.governmentProcedure.prevProc}")
    private String governmentAgencyGoodsItems_governmentProcedure_prevProc;

    @Value("${sad.governmentAgencyGoodsItems.governmentProcedure.declProcType}")
    private String governmentAgencyGoodsItems_governmentProcedure_declProcType;

    @Value("${sad.governmentAgencyGoodsItems.governmentProcedure.procNat2}")
    private String governmentAgencyGoodsItems_governmentProcedure_procNat2;

    @Value("${sad.governmentAgencyGoodsItems.previousDocuments.category}")
    private String governmentAgencyGoodsItems_previousDocuments_category;

    @Value("${sad.governmentAgencyGoodsItems.previousDocuments.type}")
    private String governmentAgencyGoodsItems_previousDocuments_type;

    @Value("${sad.governmentAgencyGoodsItems.packagings.type}")
    private String governmentAgencyGoodsItems_packagings_type;

    @Value("${importer.code}")
    private String importer_code;

    private ObjectMapper mapper = new ObjectMapper();

    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ssX";
    private static final String SIMPLE_DATE_PATTERN = "yyyy-MM-dd";

    @Autowired
    ApplicationContext ctx;

    protected Builder() {
    }

    public Builder(ApplicationContext appContext){
        ctx = appContext;
    }

    @Bean(name="BE")
    public ItemsEnum[] getItemsBE() {
        return ItemsEnumBE.values();
    }

    @Bean(name="US")
    public ItemsEnum[] getItemsUS() {
        return ItemsEnumUS.values();
    }

    @Bean(name="SG")
    public ItemsEnum[] getItemsSG() {
        return ItemsEnumSG.values();
    }

    private Date calculateDate(Date initDate, int shift) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(initDate);
        cal.add(Calendar.DATE, shift); //minus number would decrement the days
        return cal.getTime();
    }

    public void build() throws Exception {

        ItemsEnum[] itemsEnums = (ItemsEnum[]) ctx.getBean(country.toUpperCase());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);

        SimpleDateFormat myFormat = new SimpleDateFormat(SIMPLE_DATE_PATTERN);
        Date initDate = myFormat.parse(accDateCodeInit);
        Date endDate = myFormat.parse(accDateCodeEnd);

        long days = TimeUnit.DAYS.convert((endDate.getTime() - initDate.getTime()), TimeUnit.MILLISECONDS);

        double delta = (instancesToCreateEnd - instancesToCreate)/(double) days;
//        System.out.println(delta);

        int counter = 1;
        for (int j=1; j<(days+1); j++) {
//            System.out.println((delta*j));
            final Date currentD = calculateDate(initDate, j);
            final String date = simpleDateFormat.format(currentD);
            for (int i = 0; i < instancesToCreate+(delta*j); i++) {

                final String incPadded = StringUtils.leftPad("" + (counter + externalReferenceInit), externalReferenceDigits, "0");
                counter++;
                final String externalReference = externalReferenceRoot + incPadded;

                Declaration declaration = buildDeclaration(externalReference);

                SingleAdministrativeDocument singleAdministrativeDocument = new SingleAdministrativeDocument();
                declaration.setSingleAdministrativeDocument(singleAdministrativeDocument);

                singleAdministrativeDocument.setAccDateCode(date);
                singleAdministrativeDocument.setAddDeclType1(addDeclType1);

                singleAdministrativeDocument.getAdditionalInformations().add(buildAdditionalInformation());

                singleAdministrativeDocument.setAgentStatus(agentStatus);
                singleAdministrativeDocument.setDeclarationOfficeCode(declarationOfficeCode);
                singleAdministrativeDocument.setDeclType(declType);

                singleAdministrativeDocument.setDocRefNum((currentD.getYear() - 100) + docRefNum_root + "00" + incPadded); // TODO
                singleAdministrativeDocument.setInvoiceCurrency(invoiceCurrency);

                Declarant declarant = new Declarant();
                singleAdministrativeDocument.setDeclarant(declarant);
                declarant.setCode(declarant_code);

                GoodsShipment goodsShipment = new GoodsShipment();
                singleAdministrativeDocument.setGoodsShipment(goodsShipment);

                ExportersEnum exporter = buildExporterEnum();
                goodsShipment.setExportCountry(exporter.getAlpha2());
                goodsShipment.setTrxNatCode(goodsShipment_trxNatCode);

                goodsShipment.setConsignment(buildConsignment(exporter.getAlpha2()));

                if (goodsShipment_customsValuation_present) {
                    goodsShipment.setCustomsValuation(buildCustomsValuation());
                }

                goodsShipment.setExporter(new Exporter(exporter.name()));
                goodsShipment.setTradeTerms(buildTradeTerms());

                Ucr ucr = new Ucr(externalReference);
                goodsShipment.setUcr(ucr);

                BigDecimal itemsSum = new BigDecimal(0);
                BigDecimal paymentAssessedSum = new BigDecimal(0);
                BigDecimal paymentB00assessed = new BigDecimal(0);
                for (ItemsEnum ie : itemsEnums) {
                    if (1 == (int) Math.round(Math.random())) {
                        final int qty = calculateMass(governmentAgencyGoodsItems_goodsMeasure_qty_min, governmentAgencyGoodsItems_goodsMeasure_qty_max, governmentAgencyGoodsItems_goodsMeasure_qty_increment);
//                                (int) (governmentAgencyGoodsItems_goodsMeasure_qty_max * Math.random())+governmentAgencyGoodsItems_goodsMeasure_qty_min;

                        final int mass = calculateMass(governmentAgencyGoodsItems_goodsMeasure_mass_min, governmentAgencyGoodsItems_goodsMeasure_mass_max, governmentAgencyGoodsItems_goodsMeasure_mass_increment);

                        GovernmentAgencyGoodsItem governmentAgencyGoodsItem = new GovernmentAgencyGoodsItem();
                        goodsShipment.getGovernmentAgencyGoodsItems().add(governmentAgencyGoodsItem);

                        if (governmentAgencyGoodsItems_containerIdentification_present) {
                            governmentAgencyGoodsItem.setContainerIdentification(governmentAgencyGoodsItems_containerIdentification_root + StringUtils.leftPad("" + (int) (Math.round(Math.random() * 1000000)), 7, "0"));
                        }
                        governmentAgencyGoodsItem.getAdditionalDocuments().add(buildAdditionalDocument(counter));
                        Commodity commodity = buildCommodity(ie);
                        governmentAgencyGoodsItem.setCommodity(commodity);
                        BigDecimal a = commodity.getInvoiceLine().getItemAmount();
                        itemsSum = itemsSum.add(a);

                        BigDecimal b = commodity.getInvoiceLine().getItemAmount().multiply(ie.getDutyRate());
                        paymentAssessedSum = paymentAssessedSum.add(b);

                        BigDecimal c = a.add(b).multiply(ie.getVat());
                        paymentB00assessed = paymentB00assessed.add(c);

                        governmentAgencyGoodsItem.setGoodsMeasure(buildGoodsMeasure(mass, qty));
                        governmentAgencyGoodsItem.setGovernmentProcedure(buildGovernmentProcedure());
                        governmentAgencyGoodsItem.getPreviousDocuments().add(buildPreviousDocument(counter));
                        governmentAgencyGoodsItem.getPackagings().add( buildPackaging(externalReference, qty));
                        governmentAgencyGoodsItem.setUcr( ucr );
                    }
                }

                CalculationReturn calculationReturnA00 = new CalculationReturn();
                singleAdministrativeDocument.getCalculationReturns().add(calculationReturnA00);
                calculationReturnA00.setType("A00");
                calculationReturnA00.setBasisValue(itemsSum);
                Payment payment = new Payment();
                calculationReturnA00.setPayment(payment);
                payment.setMethodCode("A");
                payment.setAssessed(paymentAssessedSum);

                CalculationReturn calculationReturnB00 = new CalculationReturn();
                singleAdministrativeDocument.getCalculationReturns().add(calculationReturnB00);
                calculationReturnB00.setType("B00");
                calculationReturnB00.setBasisValue(itemsSum.add(paymentAssessedSum));
                Payment paymentB = new Payment();
                calculationReturnB00.setPayment(paymentB);
                paymentB.setMethodCode("G");
                paymentB.setAssessed(paymentB00assessed);

                Importer importer = new Importer();
                singleAdministrativeDocument.setImporter(importer);
                importer.setCode(importer_code);

                mapper.writeValue(new File(outputDir + externalReference + ".json"), declaration);
            }
        }
    }

    /**
     * Generates a random mass value between min and max with a specified increment.
     * @param min
     * @param max
     * @param increment
     * @return
     */
    protected int calculateMass(int min, int max, int increment) {
        if (max<=min) {
            LOG.warn("The mass min is larger or equal to the max value.");
            return min;
        }
        return (((int) Math.round(Math.random() * Math.round((max - min)/increment))) * increment) + min;
    }

    private Declaration buildDeclaration(String externalReference) {
        Declaration declaration = new Declaration();
        declaration.setVersion(version);
        declaration.setDirection(direction);
        declaration.setExternalReference(externalReference);
        declaration.setMessageType(messageType);
        declaration.setStorageLocationReference(storageLocationReference);
        return declaration;
    }

    private AdditionalInformation buildAdditionalInformation() {
        AdditionalInformation additionalInformation = new AdditionalInformation();
        additionalInformation.setCode(additionalInformations_code);
        additionalInformation.setText(additionalInformations_text);
        additionalInformation.setType(additionalInformations_type);
        return additionalInformation;
    }

    private Consignment buildConsignment(String bordertransportCountry) {
        Consignment consignment = new Consignment();
        consignment.setBorderTransportMeans(buildBorderTransportMeans(bordertransportCountry));
        consignment.setArrivalTransportMeans(buildArrivalTransportMeans());
        return consignment;
    }

    private BorderTransportMeans buildBorderTransportMeans(String country) {
        BorderTransportMeans borderTransportMeans = new BorderTransportMeans();
//        borderTransportMeans.setCountry(goodsShipment_consignment_borderTransportMeans_country);
        borderTransportMeans.setCountry(country);
        borderTransportMeans.setIdentification(goodsShipment_consignment_borderTransportMeans_identification);
        borderTransportMeans.setMode(goodsShipment_consignment_borderTransportMeans_mode);
        return borderTransportMeans;
    }

    private ArrivalTransportMeans buildArrivalTransportMeans() {
        ArrivalTransportMeans arrivalTransportMeans = new ArrivalTransportMeans();
        arrivalTransportMeans.setIdentification(goodsShipment_consignment_arrivalTransportMeans_identification);
        arrivalTransportMeans.setMode(goodsShipment_consignment_arrivalTransportMeans_mode);
        return arrivalTransportMeans;
    }

    private CustomsValuation buildCustomsValuation() {
        return new CustomsValuation(goodsShipment_customsValuation_valuationMethod);
    }

    private ExportersEnum buildExporterEnum() {
        ExportersEnum exporterInstance = null;
        do {
            exporterInstance = ExportersEnum.values()[((int) Math.round(Math.random() * (ExportersEnum.values().length-1)))];
        } while (exporterInstance.getAlpha2().toUpperCase().equals(country.toUpperCase()));
         return exporterInstance;
    }

    private TradeTerms buildTradeTerms() {
        TradeTerms tradeTerms = new TradeTerms();
        tradeTerms.setPlace(goodsShipment_tradeTerms_place);
        tradeTerms.setTermsCode(goodsShipment_tradeTerms_termCode);
        return tradeTerms;
    }

    private AdditionalDocument buildAdditionalDocument(int counter) {
        AdditionalDocument additionalDocument = new AdditionalDocument();
        additionalDocument.setCategory(governmentAgencyGoodsItems_additionalDocuments_category);
        additionalDocument.setRefNum(governmentAgencyGoodsItems_additionalDocuments_refNum_root + counter);
        additionalDocument.setType(governmentAgencyGoodsItems_additionalDocuments_type);
        return  additionalDocument;
    }

    private Commodity buildCommodity(ItemsEnum ie) {
        Commodity commodity = new Commodity();
        commodity.setDescription(ie.getDescription());
        commodity.setItemId(ie.getName());
        Classification classification = new Classification();
        commodity.getClassifications().add(classification);
        classification.setCode(ie.getTaric());
        classification.setType("TARIC"); // TODO move to configuration

        InvoiceLine invoiceLine = new InvoiceLine();
        commodity.setInvoiceLine(invoiceLine);
        invoiceLine.setItemAmount(new BigDecimal((int) (1000 * Math.random()))); // TODO
        return commodity;
    }

    private GoodsMeasure buildGoodsMeasure(int mass, int qty) {
        GoodsMeasure goodsMeasure = new GoodsMeasure();
        goodsMeasure.setGmass((int)(mass * 1.1)); // TODO
        goodsMeasure.setNmass(mass); // TODO
        goodsMeasure.setQty(qty); // TODO
        return goodsMeasure;
    }

    private GovernmentProcedure buildGovernmentProcedure() {
        GovernmentProcedure governmentProcedure = new GovernmentProcedure();
        governmentProcedure.setProc(governmentAgencyGoodsItems_governmentProcedure_proc);
        governmentProcedure.setPrevProc(governmentAgencyGoodsItems_governmentProcedure_prevProc);
        governmentProcedure.setDeclProcType(governmentAgencyGoodsItems_governmentProcedure_declProcType);
        governmentProcedure.setProcNat2(governmentAgencyGoodsItems_governmentProcedure_procNat2);
        return governmentProcedure;
    }

    private AdditionalDocument buildPreviousDocument(int counter) {
        AdditionalDocument previousDocument = new AdditionalDocument();
        previousDocument.setCategory(governmentAgencyGoodsItems_previousDocuments_category);
        previousDocument.setRefNum(governmentAgencyGoodsItems_additionalDocuments_refNum_root + counter);
        previousDocument.setType(governmentAgencyGoodsItems_previousDocuments_type);
        return previousDocument;
    }

    private Packaging buildPackaging(String externalReference, int qty) {
        Packaging packaging = new Packaging();
        packaging.setQuantity(qty); // TODO
        packaging.setShippingMarks(externalReference);
        packaging.setType(governmentAgencyGoodsItems_packagings_type);
        return packaging;
    }

}
