import sys
import time


def main(argv):
    for i in range(5):
        print(f"Message #{i + 1}")
        time.sleep(1)


if __name__ == "__main__":
    try:
        main(sys.argv[1:])
    except KeyboardInterrupt:
        print("Interrupted from keyboard.")
