public class SimpleRSA {

    // Function for modular exponentiation: (base^exp) % mod
    public static int modExp(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;

        while (exp > 0) {
            // If exp is odd, multiply the base with result
            if ((exp % 2) == 1) {
                result = (result * base) % mod;
            }
            // Update base and exp for next iteration
            base = (base * base) % mod;
            exp = exp / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        // Step 1: Choose two prime numbers
        int p = 11; // First prime number
        int q = 13; // Second prime number

        // Step 2: Calculate n = p * q and Ï† = (p-1) * (q-1)
        int n = p * q; // n = 11 * 13 = 143
        int phi = (p - 1) * (q - 1); // Ï† = (11-1) * (13-1) = 120

        // Step 3: Choose e such that 1 < e < Ï† and gcd(e, Ï†) = 1
        int e = 7; // Public key exponent (manually chosen as a small coprime of Ï†)

        // Step 4: Compute d such that (e * d) % Ï† = 1
        int d = 0;
        for (int i = 1; i < phi; i++) {
            if ((e * i) % phi == 1) {
                d = i; // Found d
                break;
            }
        }

        // Display keys
        System.out.println("Public Key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private Key (d): " + d);

        // Step 5: Encrypt a message
        int plaintext = 9; // Message to encrypt
        int ciphertext = modExp(plaintext, e, n); // C = (P^e) mod n
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Ciphertext: " + ciphertext);

        // Step 6: Decrypt the message
        int decryptedMessage = modExp(ciphertext, d, n); // P = (C^d) mod n
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
