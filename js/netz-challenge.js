// - dividend. Required. A non-zero, non-negative integer
// - divisor.  Required. A non-zero, non-negative integer
const manualDivision = (dividend, divisor) => {
  const isDividendInvalid = dividend == null || dividend <= 0;
  if (isDividendInvalid) {
    console.log("Dividend is invalid.");
  }

  const isDivisorInvalid = divisor == null || divisor <= 0;
  if (isDivisorInvalid) {
    console.log("Divisor is invalid.");
  }

  if (isDividendInvalid || isDivisorInvalid) {
    throw new Error("Invalid parameters");
  }

  let remainingDividend = dividend;
  let quotient = 0;

  while (remainingDividend - divisor >= 0) {
    remainingDividend -= divisor;
    quotient++;
  }

  console.log(
    `${quotient}${remainingDividend > 0 ? "r" + remainingDividend : ""}`
  );
};

manualDivision(10, 2);
manualDivision(15, 4);
manualDivision(7, 11);
